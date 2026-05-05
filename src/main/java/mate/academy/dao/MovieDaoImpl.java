package mate.academy.dao;

import java.util.Optional;
import mate.academy.exception.DataProcessingException;
import mate.academy.model.Movie;
import mate.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) {
        SessionFactory sessionFactory = HibernateUtil.getSession();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(movie);
        try {
            transaction.commit();
        } catch (Exception e) {
            throw new DataProcessingException("The transaction was unsuccessful");
        } finally {
            session.close();
        }
        return movie;
    }

    @Override
    public Optional<Movie> get(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSession();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Movie movie = session.find(Movie.class, id);

        try {
            transaction.commit();
        } catch (Exception e) {
            throw new DataProcessingException("The transaction was unsuccessful");

        } finally {
            session.close();
        }
        return Optional.ofNullable(movie);
    }
}

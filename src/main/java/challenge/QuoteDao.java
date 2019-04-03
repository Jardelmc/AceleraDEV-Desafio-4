package challenge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteDao {

    public Quote getQuote() throws SQLException {

        Connection connection = null;
        try {
            connection = ConnectionFactory.createConnection();
            String sql = "select * from scripts";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Random aleatorio = new Random();
            int valor = aleatorio.nextInt(18305) + 1;

            while (rs.next()) {
                if (rs.getInt(1) == valor) {
                    Quote quote = new Quote();
                    quote.setQuote(rs.getString("detail"));
                    return quote;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Quote getQuoteByActor(String actor) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionFactory.createConnection();
            String sql = "select * from scripts where actor='"+actor+"'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List <String>frases = new ArrayList<String>();
            while (rs.next()) {
                frases.add(rs.getString("detail"));
            }
            Random aleatorio = new Random();
            int valor = aleatorio.nextInt(frases.size()-1) + 1;
            Quote quote = new Quote();
            quote.setActor(actor);
            quote.setQuote(frases.get(valor));
            return quote;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}

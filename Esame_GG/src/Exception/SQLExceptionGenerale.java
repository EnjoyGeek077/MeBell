package Exception;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLExceptionGenerale extends SQLException {

	@Override
	public void printStackTrace() {
		JOptionPane.showMessageDialog(null, "Errore con il database", "Error", JOptionPane.ERROR_MESSAGE);
	}

}

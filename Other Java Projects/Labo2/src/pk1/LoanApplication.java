package pk1;
import java.util.*;
public class LoanApplication {
	private String firstName;
	private String surname;
	private String pesel;
	private String nip;
	private String bankAccountNumber;
	private Date dateOfBirth;
	private String gender;
	public LoanApplication(String firstName, String surname, String pesel, String nip, String bankAccountNumber, Date dateOfBirth, String gender) {
		
		this.firstName = firstName;
		this.surname = surname;
		this.pesel = pesel;
		this.nip = nip;
		this.bankAccountNumber = bankAccountNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
}

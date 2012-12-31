import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


// Okno "About"
class AboutDialog extends JDialog {
    
	private static final long serialVersionUID = 8169178928427118906L;

	public AboutDialog() {

        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel name = new JLabel("Biblioteka, wersja 1.00");
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setAlignmentX(0.5f);
        add(name);

        add(Box.createRigidArea(new Dimension(0, 50)));

        JButton close = new JButton("Zamknij");

        // Akcja podpieta pod przycisk "Zamknij"
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        close.setAlignmentX(0.5f);
        add(close);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("O programie");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(200, 200);
    }
}

// Okno dodawania nowego czytelnika
class ReaderDialog extends JDialog {

	private static final long serialVersionUID = 9092551044456132035L;
	private Biblioteka bib;
	
    public ReaderDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Imiê:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField fnameTextField = new JTextField(20);
        add(fnameTextField);
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lname = new JLabel("Nazwisko:");
        lname.setFont(new Font("Serif", Font.BOLD, 12));
        lname.setAlignmentX(0.5f);
        add(lname);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField lnameTextField = new JTextField(20);
        add(lnameTextField);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton addButton = new JButton("Dodaj");
        
        
        
        // Akcja podpieta pod przycisk "Dodaj"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.dodajCzytelnika(new Czytelnik(fnameTextField.getText(), lnameTextField.getText(), bib.kolejny_numer_czytelnika()));
                dispose();
              
                JOptionPane.showMessageDialog(null, "Dodano nowego czytelnika");
            }
        });

        addButton.setAlignmentX(0.5f);
        add(addButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Dodaj czytelnika");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 220);
    }
    
}

//Okno usuwania czytelnika
class DeleteReaderDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
 public DeleteReaderDialog(Biblioteka bib) {
 	this.bib = bib;	
     initUI();
 }

 public final void initUI() {

     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel fname = new JLabel("Czytelnicy:");
     fname.setFont(new Font("Serif", Font.BOLD, 12));
     fname.setAlignmentX(0.5f);
     add(fname);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JComboBox readersComboBox = new JComboBox(bib.getCzytelnicy().toArray());
     readersComboBox.setSelectedIndex(-1);
     readersComboBox.setPreferredSize(new Dimension(450, 22));
     readersComboBox.setMaximumSize(new Dimension(450, 22));
     add(readersComboBox);
     
     

     add(Box.createRigidArea(new Dimension(0, 10)));

     JButton deleteButton = new JButton("Usuñ");
     
     // Akcja podpieta pod przycisk "Usuñ
     deleteButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         	bib.usunCzytelnika(bib.getCzytelnicy().get(readersComboBox.getSelectedIndex()));
             dispose();
             JOptionPane.showMessageDialog(null, "Usuniêto u¿ytkownika");
         }
     });

     deleteButton.setAlignmentX(0.5f);
     add(deleteButton);
     
     add(Box.createRigidArea(new Dimension(0, 10)));
     
     JButton cancelButton = new JButton("Anuluj");
     cancelButton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent event) {
             dispose();
         }
     });

     cancelButton.setAlignmentX(0.5f);
     add(cancelButton);


     setModalityType(ModalityType.APPLICATION_MODAL);

     setTitle("Usuwanie czytelnika");
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setSize(500, 220);
 }
}


//Okno dodawania nowej ksi¹¿ki
class BookDialog extends JDialog {

	private static final long serialVersionUID = 9092551044456132035L;
	private Biblioteka bib;
	
 public BookDialog(Biblioteka bib) {
 	this.bib = bib;	
     initUI();
 }

 public final void initUI() {

     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel fname = new JLabel("Autor:");
     fname.setFont(new Font("Serif", Font.BOLD, 12));
     fname.setAlignmentX(0.5f);
     add(fname);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JTextField fnameTextField = new JTextField(20);
     add(fnameTextField);
     
     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel lname = new JLabel("Tytu³:");
     lname.setFont(new Font("Serif", Font.BOLD, 12));
     lname.setAlignmentX(0.5f);
     add(lname);
     
     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JTextField lnameTextField = new JTextField(20);
     add(lnameTextField);
     
     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel iname = new JLabel("ISBN:");
     iname.setFont(new Font("Serif", Font.BOLD, 12));
     iname.setAlignmentX(0.5f);
     add(iname);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JTextField inameTextField = new JTextField(20);
     add(inameTextField);
     
     JLabel jname = new JLabel("Iloœæ egzemplarzy:");
     jname.setFont(new Font("Serif", Font.BOLD, 12));
     jname.setAlignmentX(0.5f);
     add(jname);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JTextField jnameTextField = new JTextField(20);
     add(jnameTextField);
     

     add(Box.createRigidArea(new Dimension(0, 10)));

     JButton addButton = new JButton("Dodaj");
     
     // Akcja podpieta pod przycisk "Dodaj"
     addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         	bib.dodajKsiazke(new Ksiazka(fnameTextField.getText(), lnameTextField.getText(), inameTextField.getText(), Integer.parseInt (jnameTextField.getText())));
             dispose();
             JOptionPane.showMessageDialog(null, "Dodano now¹ ksi¹¿kê");
         }
     });

     addButton.setAlignmentX(0.5f);
     add(addButton);
     
     add(Box.createRigidArea(new Dimension(0, 10)));
     
     JButton cancelButton = new JButton("Anuluj");
     cancelButton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent event) {
             dispose();
         }
     });

     cancelButton.setAlignmentX(0.5f);
     add(cancelButton);


     setModalityType(ModalityType.APPLICATION_MODAL);

     setTitle("Dodaj ksiazke");
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setSize(400,300);
 }
}

//Okno usuwania ksiazki
class DeleteBookDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
 public DeleteBookDialog(Biblioteka bib) {
 	this.bib = bib;	
     initUI();
 }

 public final void initUI() {

     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

     
     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel lname = new JLabel("Ksi¹¿ki:");
     lname.setFont(new Font("Serif", Font.BOLD, 12));
     lname.setAlignmentX(0.5f);
     add(lname);
     
     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JComboBox booksComboBox = new JComboBox(bib.getKsiazki().toArray());
     booksComboBox.setSelectedIndex(-1);
     booksComboBox.setPreferredSize(new Dimension(450, 22));
     booksComboBox.setMaximumSize(new Dimension(450, 22));
     add(booksComboBox);

     add(Box.createRigidArea(new Dimension(0, 10)));

     JButton deleteButton = new JButton("Usuñ");
     
     // Akcja podpieta pod przycisk "Usuñ"
     deleteButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         	bib.usunKsiazke(bib.getKsiazki().get(booksComboBox.getSelectedIndex()));
             dispose();
             JOptionPane.showMessageDialog(null, "Usuniêto ksi¹¿kê");
         }
     });

     deleteButton.setAlignmentX(0.5f);
     add(deleteButton);
     
     add(Box.createRigidArea(new Dimension(0, 10)));
     
     JButton cancelButton = new JButton("Anuluj");
     cancelButton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent event) {
             dispose();
         }
     });

     cancelButton.setAlignmentX(0.5f);
     add(cancelButton);


     setModalityType(ModalityType.APPLICATION_MODAL);

     setTitle("Usuñ ksi¹¿kê");
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setSize(500, 220);
 }
}



// Okno wypozyczania
class LendDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
    public LendDialog(Biblioteka bib) {
    	this.bib = bib;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Czytelnicy:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox readersComboBox = new JComboBox(bib.getCzytelnicy().toArray());
        readersComboBox.setSelectedIndex(-1);
        readersComboBox.setPreferredSize(new Dimension(450, 22));
        readersComboBox.setMaximumSize(new Dimension(450, 22));
        add(readersComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lname = new JLabel("Ksi¹¿ki:");
        lname.setFont(new Font("Serif", Font.BOLD, 12));
        lname.setAlignmentX(0.5f);
        add(lname);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox booksComboBox = new JComboBox(bib.getKsiazki().toArray());
        booksComboBox.setSelectedIndex(-1);
        booksComboBox.setPreferredSize(new Dimension(450, 22));
        booksComboBox.setMaximumSize(new Dimension(450, 22));
        add(booksComboBox);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton lendButton = new JButton("Wypo¿ycz");
        
        // Akcja podpieta pod przycisk "Wypozycz"
        lendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	bib.wypozyczKsiazkeCzytelnikowi(bib.getKsiazki().get(booksComboBox.getSelectedIndex()), bib.getCzytelnicy().get(readersComboBox.getSelectedIndex()));
                dispose();
                JOptionPane.showMessageDialog(null, "Ksi¹¿kê wypo¿yczono");
            }
        });

        lendButton.setAlignmentX(0.5f);
        add(lendButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Wypo¿ycz ksi¹¿ke czytelnikowi");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}

//Okno zwrotu ksi¹¿ki
class BorrowDialog extends JDialog {

	private static final long serialVersionUID = -4626991721261309951L;
	private Biblioteka bib;
	
 public BorrowDialog(Biblioteka bib) {
 	this.bib = bib;	
     initUI();
 }

 public final void initUI() {

     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel fname = new JLabel("Czytelnicy:");
     fname.setFont(new Font("Serif", Font.BOLD, 12));
     fname.setAlignmentX(0.5f);
     add(fname);

     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JComboBox readersComboBox = new JComboBox(bib.getCzytelnicy().toArray());
     readersComboBox.setSelectedIndex(-1);
     readersComboBox.setPreferredSize(new Dimension(450, 22));
     readersComboBox.setMaximumSize(new Dimension(450, 22));
     add(readersComboBox);
     
     add(Box.createRigidArea(new Dimension(0, 6)));

     JLabel lname = new JLabel("Wypozyczenia Czytelnika:");
     lname.setFont(new Font("Serif", Font.BOLD, 12));
     lname.setAlignmentX(0.5f);
     add(lname);
     
     add(Box.createRigidArea(new Dimension(0, 6)));
     
     final JComboBox wypozyczeniaComboBox = new JComboBox(bib.getWypozyczenia().toArray());
     wypozyczeniaComboBox.setSelectedIndex(-1);
     wypozyczeniaComboBox.setPreferredSize(new Dimension(450, 22));
     wypozyczeniaComboBox.setMaximumSize(new Dimension(450, 22));
     add(wypozyczeniaComboBox); 
    

     add(Box.createRigidArea(new Dimension(0, 10)));

     JButton borrowButton = new JButton("Zwróæ");
     
     // Akcja podpieta pod przycisk "Zwróæ"
     borrowButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         	bib.usunWypozyczenie(bib.getWypozyczenia().get(wypozyczeniaComboBox.getSelectedIndex()) );
             dispose();
         }
     });

     borrowButton.setAlignmentX(0.5f);
     add(borrowButton);
     
     add(Box.createRigidArea(new Dimension(0, 10)));
     
     JButton cancelButton = new JButton("Anuluj");
     cancelButton.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent event) {
             dispose();
         }
     });

     cancelButton.setAlignmentX(0.5f);
     add(cancelButton);


     setModalityType(ModalityType.APPLICATION_MODAL);

     setTitle("Zwróæ ksi¹¿kê");
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setSize(500, 220);
 }
}

// Klasa Biblioteka
public class Biblioteka extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3167090132551198602L;
	// Listy ksiazek, czytelnikow i wypozyczen
	ArrayList<Ksiazka> ksiazki;
	ArrayList<Czytelnik> czytelnicy;
	ArrayList<Wypozyczenie> wypozyczenia;
	long numer_czytelnika;
	
	/**
	 * Konstruktor
	 */
	public Biblioteka() {
		this.ksiazki = new ArrayList<Ksiazka>();
		this.czytelnicy = new ArrayList<Czytelnik>();
		this.wypozyczenia = new ArrayList<Wypozyczenie>();
		this.numer_czytelnika = 1;
		initUI(this);
	}
	// Metoda inicjalizujÄ…ca GUI
	public final void initUI(final Biblioteka bib) {
		
		// Panel
		JPanel panel = new JPanel();

		// Pole tekstowe
		final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(false);
        
        // Dodanie pola tekstowego do panelu
        panel.add(textArea);
        
        // Dodanie panelu do JFrame
        add(panel);
        pack();
        // Pasek menu
        JMenuBar menubar = new JMenuBar();
        // Menu Biblioteka
        JMenu lib = new JMenu("Biblioteka");
        lib.setMnemonic(KeyEvent.VK_B);
        // Pozycja menu: Zakoncz
        JMenuItem eMenuItem = new JMenuItem("Zakoñcz");
        eMenuItem.setMnemonic(KeyEvent.VK_Z);
        eMenuItem.setToolTipText("Zakoñcz program");
        // Podpiecie akcji pod "Zakoncz"
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
        		System.exit(0);
            }
        });

        // Pozycja menu: Wyswietl czytelnikow
        JMenuItem usersMenuItem = new JMenuItem("Wyœwietl czytelników");
        usersMenuItem.setMnemonic(KeyEvent.VK_C);
        usersMenuItem.setToolTipText("Wyœwietlenie listy czytelników");
        // Podpiecie akcji pod "Wyswietl czytelnikow"
        usersMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Czytelnik c: czytelnicy) {  
            		textArea.append(c+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Wyswietl ksiazki
        JMenuItem booksMenuItem = new JMenuItem("Wyœwietl ksi¹¿ki");
        booksMenuItem.setMnemonic(KeyEvent.VK_K);
        booksMenuItem.setToolTipText("Wyœwietlenie listy ksi¹¿ek");
        // Podpiecie akcji pod "Wyswietl ksiazki"
        booksMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Ksiazka k: ksiazki) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });

        // Pozycja menu: Wyswietl wypozyczenia
        JMenuItem lendsMenuItem = new JMenuItem("Wyœwietl wypo¿yczenia");
        lendsMenuItem.setMnemonic(KeyEvent.VK_W);
        lendsMenuItem.setToolTipText("Wyœwietlenie listy ksi¹¿ek");
        // Podpiecie akcji pod "Wyswietl wypozyczenia"
        lendsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            
            	for (Wypozyczenie k: wypozyczenia) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });
        
        // Pozycja menu: Dodaj nowego czytelnika
        JMenuItem newReaderMenuItem = new JMenuItem("Dodaj nowego czytelnika");
        newReaderMenuItem.setMnemonic(KeyEvent.VK_N);
        // Podpiecie akcji pod "Dodaj nowego czytelnika"
        newReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ReaderDialog ad = new ReaderDialog(bib);
                ad.setVisible(true);
            }
        });
        
        // Pozycja menu: Usuñ  czytelnika
        JMenuItem newDeleteReaderMenuItem = new JMenuItem("Usuñ  czytelnika");
        newDeleteReaderMenuItem.setMnemonic(KeyEvent.VK_U);
        // Podpiecie akcji pod "Usuñ czytelnika"
        newDeleteReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DeleteReaderDialog ad = new DeleteReaderDialog(bib);
                ad.setVisible(true);
            }
        });
        
        // Pozycja menu: Dodaj nowa ksiazke
        JMenuItem newBookMenuItem = new JMenuItem("Dodaj now¹ ksiazkê");
        newBookMenuItem.setMnemonic(KeyEvent.VK_S);
        // Podpiecie akcji pod "Dodaj nowaksiazke"
        newBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                BookDialog ad = new BookDialog(bib);
                ad.setVisible(true);
            }
        });
        
        // Pozycja menu: Usuñ  ksiazke
        JMenuItem newDeleteBookMenuItem = new JMenuItem("Usuñ  ksi¹¿kê");
        newDeleteBookMenuItem.setMnemonic(KeyEvent.VK_I);
        // Podpiecie akcji pod "Usuñ ksiazke"
        newDeleteBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DeleteBookDialog ad = new DeleteBookDialog(bib);
                ad.setVisible(true);
            }
        });
        
        
        // Pozycja menu: Wypozycz ksiazke czytelnikowi
        JMenuItem lendBookMenuItem = new JMenuItem("Wypo¿ycz ksi¹¿kê czytelnikowi");
        lendBookMenuItem.setMnemonic(KeyEvent.VK_Y);
        // Podpiecie akcji pod "Wypozycz ksiazke czytelnikowi"
        lendBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LendDialog ad = new LendDialog(bib);
                ad.setVisible(true);
            }
        });
        
       // Pozycja menu: Zwróæ ksi¹¿kê
        JMenuItem borrowBookMenuItem = new JMenuItem("Czytelnik zwraca ksi¹¿kê");
        borrowBookMenuItem.setMnemonic(KeyEvent.VK_L);
        // Podpiecie akcji pod "Zwróæ ksi¹¿kê"
        borrowBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                BorrowDialog ad = new BorrowDialog(bib);
                ad.setVisible(true);
            }
        });

        // Dodanie pozycji do menu "Biblioteka"
        lib.add(lendBookMenuItem);
        lib.add(borrowBookMenuItem);
        lib.addSeparator();
        lib.add(newReaderMenuItem);
        lib.add(newDeleteReaderMenuItem);
        lib.add(newBookMenuItem);
        lib.add(newDeleteBookMenuItem);
        lib.addSeparator();
        lib.add(usersMenuItem);        
        lib.add(booksMenuItem);
        lib.add(lendsMenuItem);
        lib.addSeparator();
        lib.add(eMenuItem);

        // Menu "Pomoc"
        JMenu help = new JMenu("Pomoc");
        help.setMnemonic(KeyEvent.VK_P);
        
        // Pozycja menu: O programie
        JMenuItem about = new JMenuItem("O programie");
        about.setMnemonic(KeyEvent.VK_O);
        
        // Podpiecie akcji pod "O programie"
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AboutDialog ad = new AboutDialog();
                ad.setVisible(true);
            }
        });

        // Dodanie pozycji "O programie" do menu "Pomoc"
        help.add(about);
        
        // Dodanie menu "Biblioteka" i "Pomoc" do paska menu
        menubar.add(lib);
        menubar.add(help);

        setJMenuBar(menubar);
        
        setTitle("Biblioteka");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	// Metody get i set
	
	/**
	 * @return the ksiazki
	 */
	public ArrayList<Ksiazka> getKsiazki() {
		return ksiazki;
	}


	/**
	 * @param ksiazki the ksiazki to set
	 */
	public void setKsiazki(ArrayList<Ksiazka> ksiazki) {
		this.ksiazki = ksiazki;
	}

	/**
	 * @return the czytelnicy
	 */
	public ArrayList<Czytelnik> getCzytelnicy() {
		return czytelnicy;
	}

	/**
	 * @param czytelnicy the czytelnicy to set
	 */
	public void setCzytelnicy(ArrayList<Czytelnik> czytelnicy) {
		this.czytelnicy = czytelnicy;
	}

	/**
	 * @return the wypozyczenia
	 */
	public ArrayList<Wypozyczenie> getWypozyczenia() {
		return wypozyczenia;
	}

	
	/**
	 * @param wypozyczenia the wypozyczenia to set
	 */
	public void setWypozyczenia(ArrayList<Wypozyczenie> wypozyczenia) {
		this.wypozyczenia = wypozyczenia;
	}

	public long getNumer_czytelnika() {
		return numer_czytelnika;
	}

	public void setNumer_czytelnika(long numer_czytelnika) {
		this.numer_czytelnika = numer_czytelnika;
	}
	
	public long kolejny_numer_czytelnika() {
		return numer_czytelnika++;
	}
	
	public void dodajKsiazke(Ksiazka k) {
		ksiazki.add(k);
	}

	public void dodajCzytelnika(Czytelnik c) {
		czytelnicy.add(c);
	}

	public void dodajWypozyczenie(Wypozyczenie w) {
		wypozyczenia.add(w);
	}

	public void usunKsiazke(Ksiazka k) {
		ksiazki.remove(k);
	}

	public void usunCzytelnika(Czytelnik c) {
		czytelnicy.remove(c);
	}

	public void usunWypozyczenie(Wypozyczenie w) {
		wypozyczenia.remove(w);
	}
	
	public boolean wypozyczKsiazkeCzytelnikowi(Ksiazka k, Czytelnik c) {
		if (k.wypozycz()) {
			dodajWypozyczenie(new Wypozyczenie(k, c));
			return true;
		}
		else 
			return false;
	}

	public boolean wyswietlWypozyczeniaCzytelnika (Wypozyczenie w, Czytelnik c) {
		if (w.wypozyczona()) {
			wyswietlWypozyczenie(new Wypozyczenie(w, c));
			return true;
		}
		else 
			return false;
	}
	
	private void wyswietlWypozyczenie(Wypozyczenie wypozyczenie) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
      			Biblioteka bib = new Biblioteka();
                bib.dodajCzytelnika(new Czytelnik("Jan", "Kowalski", bib.kolejny_numer_czytelnika()));
                bib.dodajCzytelnika(new Czytelnik("Dariusz", "Malinowski", bib.kolejny_numer_czytelnika()));
                bib.dodajCzytelnika(new Czytelnik("Wojciech", "Kaminski", bib.kolejny_numer_czytelnika()));
                bib.dodajKsiazke(new Ksiazka("D. Thomas", "Programming Ruby 1.9", "978-1-934356-08-1", 5));
                bib.dodajKsiazke(new Ksiazka("J. Loeliger", "Version Control with Git", "978-0-596-52012-0", 2));
                bib.dodajKsiazke(new Ksiazka("J.E.F. Friedl", "Matering Regular Expressions", "978-0-596-52812-6", 1));
                bib.setVisible(true);
            }
        });
	}
	
}

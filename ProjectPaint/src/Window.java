import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private Drawing drawing;

    //Button initialization
    private JButton btnNoir = new JButton("Noir");
    private JButton btnRouge = new JButton("Rouge");
    private JButton btnVert = new JButton("Vert");
    private JButton btnBleu = new JButton("Bleu");
    private JButton btnJaune = new JButton("Jaune");
    private JButton btnRose = new JButton("Rose");
    private JButton btnMagenta = new JButton("Magenta");
    private JButton btnOrange = new JButton("Orange");
    private JButton btnEllipse = new JButton("Ellipse");
    private JButton btnRectangle = new JButton("Rectangle");
    private JButton btnCarre = new JButton("Carre");
    private JButton btnCercle = new JButton("Cercle");


    public Window(String title, int x, int y) {
        super(title);
        this.setSize(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.drawing = new Drawing();
        this.setJMenuBar( createMenuBar ());
        Container contentPanel = this.getContentPane();
        JPanel drawPanel = new JPanel(new GridLayout(1,1));
        drawPanel.add(drawing);
        contentPanel.add(drawPanel);
        contentPanel.add(createSouthPanel(), "South");

        //initialize buttons as listener
        btnNoir.addActionListener(this);
        btnRouge.addActionListener(this);
        btnVert.addActionListener(this);
        btnBleu.addActionListener(this);
        btnJaune.addActionListener(this);
        btnRose.addActionListener(this);
        btnMagenta.addActionListener(this);
        btnOrange.addActionListener(this);
        btnEllipse.addActionListener(this);
        btnRectangle.addActionListener(this);
        btnCarre.addActionListener(this);
        btnCercle.addActionListener(this);


    }
    //Method to create south panel
    private JPanel createSouthPanel(){
        JPanel southPanel = new JPanel(new GridLayout(1,2));
        JPanel colorPanel = new JPanel(new GridLayout(2,4));
        JPanel shapePanel = new JPanel(new GridLayout(2,2));

        //Button color association
        btnNoir.setBackground(Color.BLACK);
        btnNoir.setForeground(Color.WHITE);
        btnRouge.setBackground(Color.RED);
        btnVert.setBackground(Color.GREEN);
        btnBleu.setBackground(Color.BLUE);
        btnBleu.setForeground(Color.WHITE);
        btnJaune.setBackground(Color.YELLOW);
        btnRose.setBackground(Color.PINK);
        btnMagenta.setBackground(Color.MAGENTA);
        btnOrange.setBackground(Color.ORANGE);

        //Adding buttons to the layouts
        colorPanel.add(btnNoir);
        colorPanel.add(btnRouge);
        colorPanel.add(btnVert);
        colorPanel.add(btnBleu);
        colorPanel.add(btnJaune);
        colorPanel.add(btnRose);
        colorPanel.add(btnMagenta);
        colorPanel.add(btnOrange);

        shapePanel.add(btnEllipse);
        shapePanel.add(btnRectangle);
        shapePanel.add(btnCarre);
        shapePanel.add(btnCercle);

        //Adding layouts to the southern strip
        southPanel.add(colorPanel);
        southPanel.add(shapePanel);

        //Change of sizing
        southPanel.setPreferredSize(new Dimension(0, 100));
        return southPanel;
    }

    //Method to create menu bar
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu( "File");
        menuBar.add (menuFile);

        JMenuItem menuNew = new JMenuItem("New");
        menuFile.add(menuNew);

        //Add shortcut (Alt+F)
        menuFile.setMnemonic('F');

        //Add button role
        menuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewConfirmation();
            }
        });
        menuFile.addSeparator();

        JMenuItem menuOpen = new JMenuItem("Open");
        menuFile.add(menuOpen);
        menuOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFiles();
            }
        });

        JMenuItem menuSave = new JMenuItem("Save");
        menuFile.add(menuSave);
        menuSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing.saveFigures();
            }
        });
        menuFile.addSeparator();

        JMenuItem menuQuit = new JMenuItem("Quit");

        //Add button role
        menuQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuitConfirmation();
            }
        });
        menuFile.add(menuQuit);

        JMenu menuAPropos = new JMenu("A propos");
        menuAPropos.setMnemonic('A');

        JMenuItem menuSource = new JMenuItem("Source");
        menuAPropos.add(menuSource);

        //Add button role
        menuSource.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Window.this, "Paint version 1 de Zambelli Lucas");
            }
        });

        menuBar.add (menuAPropos);
        return menuBar;
    }

    private void openFiles() {
        int result = JOptionPane.showConfirmDialog(this, "Voulez-vous sauvegarder ?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            //using saving method from drawing
            drawing.saveFigures();
            //using loading method from drawing
            drawing.loadFigures();
        }
        else if (result == JOptionPane.NO_OPTION){
            drawing.loadFigures();
        }

    }


    private void showNewConfirmation() {
        int result = JOptionPane.showConfirmDialog(this, "Voulez-vous sauvegarder ?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            //using saving method from drawing
            drawing.saveFigures();
            //using drawing method from drawing
            drawing.clearDrawing();
        }
        else if (result == JOptionPane.NO_OPTION){
            drawing.clearDrawing();
        }
    }

    private void showQuitConfirmation() {
        int result = JOptionPane.showConfirmDialog(this, "Voulez-vous sauvegarder ?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            // save
            drawing.saveFigures();
            JOptionPane.showMessageDialog(this, "Sauvegarde effectué");
            System.exit(0);
        }
        else if (result == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }


    public void addFigure(Figure figure) {
        this.drawing.addFigure(figure);
    }


    //Listener for south Panel
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnNoir){
            drawing.setColor(Color.BLACK);
        }
        else if (event.getSource() == btnRouge){
            drawing.setColor(Color.RED);
        }
        else if (event.getSource() == btnVert){
            drawing.setColor(Color.GREEN);
        }
        else if (event.getSource() == btnBleu){
            drawing.setColor(Color.BLUE);
        }
        else if (event.getSource() == btnJaune){
            drawing.setColor(Color.YELLOW);
        }
        else if (event.getSource() == btnRose){
            drawing.setColor(Color.PINK);
        }
        else if (event.getSource() == btnMagenta){
            drawing.setColor(Color.MAGENTA);
        }
        else if (event.getSource() == btnOrange){
            drawing.setColor(Color.ORANGE);
        }
        else if (event.getSource() == btnEllipse){
            drawing.setNameFigure("Ellipse");
        }
        else if (event.getSource() == btnCercle){
            drawing.setNameFigure("Circle");
        }
        else if (event.getSource() == btnRectangle){
            drawing.setNameFigure("Rectangle");
        }
        else if (event.getSource() == btnCarre){
            drawing.setNameFigure("Square");
        }
    }
}

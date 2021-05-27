package com.company;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer
{
    private int displaySize;
    private JImageDisplay display;
    private FractalGenerator fractal;
    private Rectangle2D.Double range;
    private int RowsRemaining;
    private JButton Reset;
    private JButton Save;
    private JComboBox Combox;

    public FractalExplorer(int size)
    {
        displaySize = size;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
    }

    public void createAndShowGUI ()
    {
        display.setLayout(new BorderLayout());
        Reset = new JButton("Reset");
        Save = new JButton("Save Image");
        Combox = new JComboBox();

        JFrame Frame = new JFrame("Fractal");
        JLabel Label = new JLabel("Fractal:");
        JPanel UpPanel = new JPanel();
        JPanel DownPanel = new JPanel();



        UpPanel.add(Label);
        UpPanel.add(Combox);
        DownPanel.add(Save);
        DownPanel.add(Reset);

        FractalGenerator Mandelbrot = new Mandelbrot();
        FractalGenerator Tricorn = new Tricorn();
        FractalGenerator BurningShip = new BurningShip();
        Combox.addItem(Mandelbrot);
        Combox.addItem(Tricorn);
        Combox.addItem(BurningShip);

        Frame.add(display,BorderLayout.CENTER);
        Frame.add(DownPanel,BorderLayout.SOUTH);
        Frame.add(UpPanel,BorderLayout.NORTH);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);
        ButtonHandler resetHandler = new ButtonHandler();
        Reset.addActionListener(resetHandler);
        ButtonHandler saveHandler = new ButtonHandler();
        Save.addActionListener(saveHandler);
        ButtonHandler fractalHandler = new ButtonHandler();
        Combox.addActionListener(fractalHandler);


        Frame.pack();
        Frame.setVisible(true);
        Frame.setResizable(false);
    }
    private void drawFractal()
    {
        EnableUI(false);

        RowsRemaining = displaySize;
        for (int y=0; y<displaySize; y++){
            FractalWorker drawRow = new FractalWorker(y);
            drawRow.execute();
        }
    }
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            if (e.getSource() instanceof JComboBox) {
                JComboBox NewFrac = (JComboBox)e.getSource();
                fractal = (FractalGenerator)NewFrac.getSelectedItem();
                fractal.getInitialRange(range);
                drawFractal();

            } else if (command.equals("Reset")) {
                fractal.getInitialRange(range);
                drawFractal();
            } else if (command.equals("Save Image"))
            {
                JFileChooser Explorer = new JFileChooser();
                Explorer.setAcceptAllFileFilterUsed(false);
                Explorer.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
                if (Explorer.showSaveDialog(display) == JFileChooser.APPROVE_OPTION)
                {
                    try {
                        javax.imageio.ImageIO.write(display.image,"png",Explorer.getSelectedFile());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(display,exception.getMessage(),"Cannot save image!",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    private class MouseHandler extends MouseAdapter
    {

        public void mouseClicked(MouseEvent e)
        {
            if (RowsRemaining != 0)
                return;
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
                    range.x + range.width, displaySize, x);

            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
                    range.y + range.height, displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(700);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
    private class FractalWorker extends SwingWorker<Object,Object>
    {
        private int y;
        int[] Col;

        private FractalWorker(int row)
        {
            y = row;
        }

        protected Object doInBackground() throws Exception {
            Col = new int[displaySize];
            for (int x = 0; x < displaySize;x++)
            {
                double xCoord = FractalGenerator.getCoord (range.x, range.x + range.width, displaySize, x);
                double yCoord = FractalGenerator.getCoord (range.y, range.y + range.height, displaySize,y);

                int numIters = fractal.numIterations(xCoord,yCoord);
                if (numIters == -1)
                    Col[x] = 0;
                else
                {
                    float hue = 0.7f + (float) numIters / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    Col[x] = rgbColor;
                }
            }
            return null;
        }
        protected void done(){
            for (int x = 0; x < Col.length;x++)
                display.drawPixel(x,y,Col[x]);
            display.repaint(0,0,y,displaySize,1);
            RowsRemaining--;
            if (RowsRemaining == 0)
                EnableUI(true);

        }
    }
    private void EnableUI(boolean val)
    {
        Combox.setEnabled(val);
        Save.setEnabled(val);
        Reset.setEnabled(val);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PrimerDesign;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author 0907822r
 */
public class AreaSelection extends javax.swing.JPanel {
    
    private boolean isOStrand = true;
    //private Highlighter high;
    //private int from;
    //private int to;
    private int startTarget, endTarget;
    private String lineNums;


    public int getStartTarget() {
        return startTarget;
    }

    public void setStartTarget(int startTarget) {
        this.startTarget = startTarget;
    }

    public int getEndTarget() {
        return endTarget;
    }

    public void setEndTarget(int endTarget) {
        this.endTarget = endTarget;
    }
    
    private class AreaCaretListener implements CaretListener{

        @Override
        public void caretUpdate(CaretEvent e) {
            if (fromTextField.getText().toString().isEmpty() && toTextField.getText().toString().isEmpty()){
                if (e.getSource().equals(oStrandTextPane) || e.getSource().equals(cStrandTextPane)) {
                    fromTextField.setText(Integer.toString(e.getMark()));
                    int numSpaces = (e.getDot() - e.getMark()) / 10;
                    toTextField.setText(Integer.toString(e.getDot() - numSpaces));
                }
                if (fromTextField.getText().toString().equalsIgnoreCase(toTextField.getText().toString())) {
                    fromTextField.setText(null);
                    toTextField.setText(null);
                }
            }
        }
        
    }
    
    /**
     * Creates new form areaSelection
     */
    public AreaSelection() {
        initComponents();
        //high = sequenceTextArea.getHighlighter();
        //from = 0;
        //to = 0;
        StyleContext sc = new StyleContext();
        final DefaultStyledDocument oDoc = new DefaultStyledDocument(sc);
        final DefaultStyledDocument cDoc = new DefaultStyledDocument(sc);
        final DefaultStyledDocument bDoc = new DefaultStyledDocument(sc);
        
        Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
        final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
        StyleConstants.setFontFamily(mainStyle, "monospaced");
        
        Style complementaryStyle = sc.addStyle("ComplementaryStyle", defaultStyle);
        StyleConstants.setFontFamily(complementaryStyle, "monospaced");
        StyleConstants.setForeground(complementaryStyle, Color.BLUE);
        
        Style originalStyle = sc.addStyle("OriginalStyle", defaultStyle);
        StyleConstants.setFontFamily(originalStyle, "monospaced");
        StyleConstants.setForeground(originalStyle, Color.ORANGE);
        
        oDoc.setLogicalStyle(0, mainStyle);
        cDoc.setLogicalStyle(0, mainStyle);
        bDoc.setLogicalStyle(0, originalStyle);
        
        try {
            // Add the text to the document
            oDoc.insertString(0, PrimerDesign.start.getInSequence().toString('o', 10, 70), null);
            cDoc.insertString(0, PrimerDesign.start.getInSequence().toString('c', 10, 70), null);
            bDoc.insertString(0, PrimerDesign.start.getInSequence().toString('b', 10, 70), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(PrimerSelectionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        oStrandTextPane.setDocument(oDoc);
        cStrandTextPane.setDocument(cDoc);
        bStrandTextPane.setDocument(bDoc);
        
        // Section for colouring the complementary strand
        int colourStart = 0;
        while(colourStart <= bDoc.getLength()){
            
            if((colourStart + 154) > bDoc.getLength()){
                bDoc.setCharacterAttributes(colourStart, 77 -(154 - (bDoc.getLength() - colourStart))/2, complementaryStyle, false);
            }
            else{
                bDoc.setCharacterAttributes(colourStart, 77, complementaryStyle, false);
            }
            
            colourStart += 154;
        }
        
        lineNums = "";
        int x = 1;
        for(int i = 0; x < PrimerDesign.start.getInSequence().length(); i++){
            lineNums += x + "\n";
            x += 70;
        }
        lineNumberTextArea.setText(lineNums);
        lineNumberTextArea.setCaretPosition(0);
        
        oStrandScroll.getVerticalScrollBar().setModel(
                lineAreaScroll.getVerticalScrollBar().getModel());
        cStrandScroll.getVerticalScrollBar().setModel(
                lineAreaScroll.getVerticalScrollBar().getModel());
        bStrandScroll.getVerticalScrollBar().setModel(
                lineAreaScroll.getVerticalScrollBar().getModel());
        
        CaretListener caretListener = new AreaCaretListener();
        oStrandTextPane.addCaretListener(caretListener);
        cStrandTextPane.addCaretListener(caretListener);
        
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instructionTextPane = new javax.swing.JTextPane();
        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        toTextField = new javax.swing.JTextField();
        fromTextField = new javax.swing.JTextField();
        lineAreaScroll = new javax.swing.JScrollPane();
        lineNumberTextArea = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        oStrandScroll = new javax.swing.JScrollPane();
        oStrandTextPane = new javax.swing.JTextPane();
        cStrandScroll = new javax.swing.JScrollPane();
        cStrandTextPane = new javax.swing.JTextPane();
        bStrandScroll = new javax.swing.JScrollPane();
        bStrandTextPane = new javax.swing.JTextPane();

        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Target Sequence Selection");

        instructionTextPane.setEditable(false);
        instructionTextPane.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        instructionTextPane.setText("Specify the region to be amplified by PCR. Indicate the region using the numbers on the left hand side and write these in the boxes below.");
        jScrollPane2.setViewportView(instructionTextPane);

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        fromLabel.setText("From:");

        toLabel.setText("To:");

        lineNumberTextArea.setColumns(5);
        lineNumberTextArea.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        lineNumberTextArea.setRows(5);
        lineNumberTextArea.setTabSize(4);
        lineAreaScroll.setViewportView(lineNumberTextArea);

        jTabbedPane1.setBackground(new java.awt.Color(254, 254, 254));

        oStrandTextPane.setEditable(false);
        oStrandTextPane.setBackground(new java.awt.Color(254, 254, 254));
        oStrandTextPane.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        oStrandScroll.setViewportView(oStrandTextPane);

        jTabbedPane1.addTab("DNA Sequence", oStrandScroll);

        cStrandTextPane.setEditable(false);
        cStrandTextPane.setBackground(new java.awt.Color(254, 254, 254));
        cStrandTextPane.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 13)); // NOI18N
        cStrandScroll.setViewportView(cStrandTextPane);

        jTabbedPane1.addTab("Complementary", cStrandScroll);

        bStrandTextPane.setEditable(false);
        bStrandTextPane.setBackground(new java.awt.Color(254, 254, 254));
        bStrandTextPane.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 13)); // NOI18N
        bStrandScroll.setViewportView(bStrandTextPane);

        jTabbedPane1.addTab("Double Stranded", bStrandScroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lineAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(fromLabel)
                        .addGap(12, 12, 12)
                        .addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(toLabel)
                        .addGap(12, 12, 12)
                        .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 610, Short.MAX_VALUE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(toLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lineAreaScroll)
                        .addGap(7, 7, 7))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(nextButton))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try {
        startTarget = Integer.parseInt(fromTextField.getText());
        endTarget = Integer.parseInt(toTextField.getText());
        System.out.println("Start target: " + startTarget +
                "\tEnd target: " + endTarget);
        // At this point, end target exists.
        
        if (startTarget < 1 || endTarget < 1)
            throw new NumberFormatException();
        if (endTarget >
                PrimerDesign.start.getInSequence().getOStrand().length())
            throw new OverShootException();     //THROWN INCORRECTLY example: length 430, 34-391 safe, 34-392 not from doesn't affect
        if ((endTarget - startTarget + 1) < 80)
            throw new LowCountException();
        if ((endTarget - startTarget + 1) > 1400)
            throw new HighCountException();
        if (PrimerDesign.start.getInSequence().containsN(startTarget, endTarget))
            throw new NException();


        PrimerDesign.window.remove(PrimerDesign.area);
        PrimerDesign.window.setVisible(false);

        PrimerDesign.primerSelect = new PrimerSelectionPanel();
        PrimerDesign.window.getContentPane().add(PrimerDesign.primerSelect);
        PrimerDesign.window.pack();
        PrimerDesign.window.setVisible(true);
        
        } catch(NumberFormatException e) {
            NumberFormatErrorBox nfeb = new NumberFormatErrorBox(PrimerDesign.window, true);
            nfeb.setLocation(215, 138);
            nfeb.setVisible(true);
        } catch(OverShootException e1) {
            OverShootBox osb = new OverShootBox(PrimerDesign.window, true);
            osb.setLocation(215,138);
            osb.setVisible(true);
        } catch(LowCountException e2) {
            LowCountErrorBox lceb = new LowCountErrorBox(PrimerDesign.window, true);
            lceb.setLocation(215, 138);
            lceb.setVisible(true);
        } catch(HighCountException e3) {
            HighCountErrorBox hceb = new HighCountErrorBox(PrimerDesign.window, true);
            hceb.setLocation(215, 138);
            hceb.setVisible(true);
        } catch(NException e4) {
            NSequenceBox nsb = new NSequenceBox(PrimerDesign.window, true);
            nsb.setLocation(215, 138);
            nsb.setVisible(true);
        }
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        PrimerDesign.window.remove(PrimerDesign.area);
        PrimerDesign.window.setVisible(false);
        
        PrimerDesign.window.getContentPane().add(PrimerDesign.start);
        PrimerDesign.window.pack();
        PrimerDesign.window.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    /* this was a mistake, need to make some sort of keyeventlistener class
    public void keyTyped(KeyEvent e) {
        System.err.println("key event detected:");
        if (e.getSource().equals(fromTextField)) {
            from = Integer.parseInt(fromTextField.getText());
            if (to == 0) {
                to = from + 1;
            }
            try {
                high.addHighlight(from, to, DefaultHighlighter.DefaultPainter);
            } catch (BadLocationException ex) {
                Logger.getLogger(AreaSelection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(toTextField)) {
            to = Integer.parseInt(fromTextField.getText());
            try {
                high.addHighlight(from, to, DefaultHighlighter.DefaultPainter);
            } catch (BadLocationException ex) {
                Logger.getLogger(AreaSelection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bStrandScroll;
    private javax.swing.JTextPane bStrandTextPane;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane cStrandScroll;
    private javax.swing.JTextPane cStrandTextPane;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JTextField fromTextField;
    private javax.swing.JTextPane instructionTextPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane lineAreaScroll;
    private javax.swing.JTextArea lineNumberTextArea;
    private javax.swing.JButton nextButton;
    private javax.swing.JScrollPane oStrandScroll;
    private javax.swing.JTextPane oStrandTextPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel toLabel;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables
}

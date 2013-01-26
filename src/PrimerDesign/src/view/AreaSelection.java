/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PrimerDesign;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
        final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
        StyleConstants.setFontFamily(mainStyle, "monospaced");
        
        oDoc.setLogicalStyle(0, mainStyle);
        cDoc.setLogicalStyle(0, mainStyle);
        try {
            // Add the text to the document
            oDoc.insertString(0, PrimerDesign.start.getInSequence().toString('o', 10, 70), null);
            cDoc.insertString(0, PrimerDesign.start.getInSequence().toString('c', 10, 70), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(PrimerSelectionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        oStrandTextPane.setDocument(oDoc);
        cStrandTextPane.setDocument(cDoc);
        
        lineNums = "";
        int x = 1;
        for(int i = 0; x < PrimerDesign.start.getInSequence().length(); i++){
            lineNums += x + "\n";
            x += 70;
        }
        lineNumberTextArea.setText(lineNums);
        lineNumberTextArea.setCaretPosition(0);
        
        oStrandScroll.getVerticalScrollBar().setModel(lineAreaScroll.getVerticalScrollBar().getModel());
        cStrandScroll.getVerticalScrollBar().setModel(lineAreaScroll.getVerticalScrollBar().getModel());
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

        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Target Sequence Selection");

        instructionTextPane.setEditable(false);
        instructionTextPane.setText("Please specify the area to be contained in the PCR product, using the boxes provided");
        jScrollPane2.setViewportView(instructionTextPane);

        nextButton.setText("Next/Go");
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
        lineNumberTextArea.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        lineNumberTextArea.setRows(5);
        lineAreaScroll.setViewportView(lineNumberTextArea);

        oStrandTextPane.setEditable(false);
        oStrandTextPane.setBackground(new java.awt.Color(255, 255, 255));
        oStrandTextPane.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 13)); // NOI18N
        oStrandScroll.setViewportView(oStrandTextPane);

        jTabbedPane1.addTab("Original", oStrandScroll);

        cStrandTextPane.setEditable(false);
        cStrandTextPane.setBackground(new java.awt.Color(255, 255, 255));
        cStrandTextPane.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 13)); // NOI18N
        cStrandScroll.setViewportView(cStrandTextPane);

        jTabbedPane1.addTab("Complementary", cStrandScroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lineAreaScroll, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(fromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(toLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fromTextField, toTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fromLabel)
                            .addComponent(toLabel)
                            .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(lineAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(backButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try {
        startTarget = Integer.parseInt(fromTextField.getText());
        endTarget = Integer.parseInt(toTextField.getText());
        PrimerDesign.window.remove(PrimerDesign.area);
        PrimerDesign.window.setVisible(false);

        PrimerDesign.primerSelect = new PrimerSelectionPanel();
        PrimerDesign.window.getContentPane().add(PrimerDesign.primerSelect);
        PrimerDesign.window.pack();
        PrimerDesign.window.setVisible(true);
        } catch(NumberFormatException e) {
            NumberFormatErrorBox nfeb = new NumberFormatErrorBox(PrimerDesign.window, true);
            nfeb.setLocation(215, 450);
            nfeb.setVisible(true);
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

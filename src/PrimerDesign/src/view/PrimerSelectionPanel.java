/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PrimerDesign;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.swing.JLabel;
import javax.swing.text.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ross
 */
public class PrimerSelectionPanel extends javax.swing.JPanel {

    /**
     * Creates new form PrimerSelectionPanel
     */
    
    private static ConcurrentSkipListSet<Integer> matchSet;
    private String lineNums;
    
    /*
    private class PrimerFinder implements Runnable {

        private String primer;
        private String strand;

        public PrimerFinder(String p, String s) {
            primer = p;
            strand = s;
        }

        @Override
        public void run() {
            for (int i = 0; i < strand.length(); i++) {
                
                if (primer.length() > 0 && strand.substring(i, (i + primer.length() - 1)).equalsIgnoreCase(primer)) {
                    matchSet.add(i);
                } 
                //else if (matchSet.contains(i)) {
                //    matchSet.remove(i);
                //}
            }
        }
    }
    */
    public int realIndex(int x, int block) {
        //Potential issue: assumes line % block= 0.
        int xRounded = x - (x % block);
        return (x + (xRounded /block));
    }
    
    public PrimerSelectionPanel() {
        
        /*
        Issue: 
        * The number panel increments are hardcoded.
        * The block and line variables used in toString should be modifiable and
        * uniform across all screens.
        */
        
        initComponents();
        
        // Create the StyleContext and the document
        StyleContext sc = new StyleContext();
        final DefaultStyledDocument doc = new DefaultStyledDocument(sc);

        // Create and add the main document style
        Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
        final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
        StyleConstants.setFontFamily(mainStyle, "monospaced");
        //StyleConstants.setLeftIndent(mainStyle, 6);
    
        // Create and add the constant width style
        final Style cwStyle = sc.addStyle("ConstantWidth", null);
        StyleConstants.setFontFamily(cwStyle, "monospaced");
        StyleConstants.setForeground(cwStyle, Color.MAGENTA);
        StyleConstants.setBackground(cwStyle, Color.black);
        
        // Set the logical style
        doc.setLogicalStyle(0, mainStyle);
        try {
            // Add the text to the document
            doc.insertString(0, PrimerDesign.start.getInSequence().toString('o', 10, 70), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(PrimerSelectionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Integer.parseInt(PrimerDesign.area.getStartTarget()) for start
        //Integer.parseInt(PrimerDesign.area.getEndTarget()) for end
        
        int badStart = PrimerDesign.area.getStartTarget() -1;
        int badEnd = PrimerDesign.area.getEndTarget() -1;
        ///*
        int realStart = realIndex(badStart, 10);
        int realEnd = realIndex(badEnd, 10) + 1;
        
        
        // Apply the character attributes
        doc.setCharacterAttributes(realStart, (realEnd - realStart), cwStyle, false);
        
        sequencePane.setDocument(doc);
        
        lineNums = "";
        int x = 1;
        for(int i = 0; x < PrimerDesign.start.getInSequence().length(); i++){
            lineNums += x + "\n";
            x += 70;
        }
        lineNumArea.setText(lineNums);
        lineNumArea.setCaretPosition(0);
        
        jScrollPane1.getHorizontalScrollBar().setModel(jScrollPane3.getHorizontalScrollBar().getModel());
        jScrollPane1.getVerticalScrollBar().setModel(jScrollPane3.getVerticalScrollBar().getModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instructionTextPane = new javax.swing.JTextPane();
        forwardPrimerTextField = new javax.swing.JTextField();
        reversePrimerTextField = new javax.swing.JTextField();
        forwardPrimerLabel = new javax.swing.JLabel();
        reversePrimerLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        showRulesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sequencePane = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        lineNumArea = new javax.swing.JTextArea();

        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Primer Design Stage 3");

        instructionTextPane.setEditable(false);
        instructionTextPane.setText("Enter the primer pair in the text fields below, click the \"Show Primer Design Rules\" button below to see general primer design rules");
        jScrollPane2.setViewportView(instructionTextPane);

        forwardPrimerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardPrimerTextFieldActionPerformed(evt);
            }
        });

        forwardPrimerLabel.setText("Forward Primer:");

        reversePrimerLabel.setText("Reverse Primer:");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next/Go");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        showRulesButton.setText("Show Primer Design Rules");
        showRulesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRulesButtonActionPerformed(evt);
            }
        });

        sequencePane.setBackground(new java.awt.Color(254, 254, 254));
        sequencePane.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 13)); // NOI18N
        sequencePane.setMaximumSize(new java.awt.Dimension(700, 2147483647));
        jScrollPane1.setViewportView(sequencePane);

        lineNumArea.setColumns(1);
        lineNumArea.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        lineNumArea.setRows(5);
        jScrollPane3.setViewportView(lineNumArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(forwardPrimerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forwardPrimerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reversePrimerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reversePrimerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(showRulesButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(24, 24, 24))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {forwardPrimerTextField, reversePrimerTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reversePrimerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forwardPrimerLabel)
                    .addComponent(reversePrimerLabel)
                    .addComponent(forwardPrimerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(nextButton)
                    .addComponent(showRulesButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane3});

    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        PrimerDesign.window.remove(PrimerDesign.primerSelect);
        PrimerDesign.window.setVisible(false);

        PrimerDesign.window.getContentPane().add(PrimerDesign.area);
        PrimerDesign.window.pack();
        PrimerDesign.window.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
       // model.TestResult pass = PrimerDesign.start.getInSequence().primerTest();
        //PrimerEvaluationDialog ped = new PrimerEvaluationDialog(PrimerDesign.window, true);
       // ped.setText(pass.getOut());
        //if (pass.getPass()) {
            PrimerDesign.start.getInSequence().setFPrimer(new model.Primer(forwardPrimerTextField.getText()));
            PrimerDesign.start.getInSequence().setRPrimer(new model.Primer(reversePrimerTextField.getText()));
            PrimerDesign.window.remove(PrimerDesign.primerSelect);
            PrimerDesign.window.setVisible(false);

            PrimerDesign.temperature = new FinalTemperaturePanel();
            PrimerDesign.window.getContentPane().add(PrimerDesign.temperature);
            PrimerDesign.window.pack();
            PrimerDesign.window.setVisible(true);
        //}
    }//GEN-LAST:event_nextButtonActionPerformed

    private void showRulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRulesButtonActionPerformed
        // should create a jdialog(?) showing the rules for primer design
       PrimerRulesDialog dialog = new PrimerRulesDialog(PrimerDesign.window, true);
       dialog.setVisible(true);
    }//GEN-LAST:event_showRulesButtonActionPerformed
   
    private void forwardPrimerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardPrimerTextFieldActionPerformed
        /*
        Thread t = new Thread(new PrimerFinder(
                forwardPrimerTextField.getText(),
                PrimerDesign.start.getInSequence().getOStrand()));
        
        t.start();
        
        System.out.println(matchSet.toString());
        */
    }//GEN-LAST:event_forwardPrimerTextFieldActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel forwardPrimerLabel;
    private javax.swing.JTextField forwardPrimerTextField;
    private javax.swing.JTextPane instructionTextPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lineNumArea;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel reversePrimerLabel;
    private javax.swing.JTextField reversePrimerTextField;
    private javax.swing.JTextPane sequencePane;
    private javax.swing.JButton showRulesButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

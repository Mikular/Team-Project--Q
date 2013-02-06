/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PrimerDesign;

/**
 *
 * @author 0901758b
 */
public class Splash extends javax.swing.JPanel {

    /**
     * Creates new form Splash
     */
    public Splash() {
        initComponents();
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
        leftLabel = new javax.swing.JLabel();
        bottomLabel = new javax.swing.JLabel();
        rightLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bottomTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        leftTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        rightTextArea = new javax.swing.JTextArea();
        startButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Polymerase Chain Reaction Tutorial");

        leftLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        leftLabel.setText("Overview");

        bottomLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        bottomLabel.setText("Further Reading");

        rightLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        rightLabel.setText("Primer Design Rules");

        bottomTextArea.setEditable(false);
        bottomTextArea.setColumns(20);
        bottomTextArea.setRows(5);
        bottomTextArea.setText("NCBI Website: http://www.ncbi.nlm.nih.gov/\nUniversity of Glasgow School of Life Sciences Moodle Site");
        jScrollPane1.setViewportView(bottomTextArea);

        leftTextArea.setEditable(false);
        leftTextArea.setColumns(20);
        leftTextArea.setLineWrap(true);
        leftTextArea.setRows(5);
        leftTextArea.setText("\nHello, and welcome to the Polymerase Chain Reaction (PCR) Tutorial.\n\nThis application will guide you through the process of PCR, particularly on primer design. You can use any sequence and any primers you like, we will make sure they are correct.\n\nIf this application crashes, or does something you don't expect, please e-mail teamprojectq@gmail.com with details of what you were doing immediately before the incident and details of the incident itself. This will hopefully allow us to fix the problem.\n\n\n\n\nCreated by Ross Barnie, Dmitrijs Jonins, Daniel McElroy, Murray Ross and Ross Taylor.");
        leftTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(leftTextArea);

        rightTextArea.setEditable(false);
        rightTextArea.setColumns(20);
        rightTextArea.setLineWrap(true);
        rightTextArea.setRows(5);
        rightTextArea.setText("\nGenerally, primers should be 20 to 30 bases in length. \n\nThe sequence you use should avoid long repetitions of a single base.  \n\nThe last base of the primer should be a 'c' or a 'g'.  You should avoid sequences which could self-anneal.  \n\nThe primers you choose should be unique to the sequence. \n\nBetween 40% and 60% of each primer sequence should consist of 'g' or 'c' bases.  \n\nAlso keep in mind that the melting temperature should be between 50 and 60°C (Tm = 2(A + T) + 4(C + G), where A, T, C and G are the number of times each of those bases appear in a primer).");
        rightTextArea.setWrapStyleWord(true);
        jScrollPane3.setViewportView(rightTextArea);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bottomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(leftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftLabel)
                    .addComponent(rightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(startButton)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // remove current panel from window
        PrimerDesign.window.getContentPane().remove(PrimerDesign.splash);
        PrimerDesign.window.setVisible(false);
        
        // add next panel to window and display
        PrimerDesign.start = new StartPanel();
        PrimerDesign.window.getContentPane().add(PrimerDesign.start);
        PrimerDesign.window.pack();
        PrimerDesign.window.setVisible(true);
    }//GEN-LAST:event_startButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bottomLabel;
    private javax.swing.JTextArea bottomTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel leftLabel;
    private javax.swing.JTextArea leftTextArea;
    private javax.swing.JLabel rightLabel;
    private javax.swing.JTextArea rightTextArea;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

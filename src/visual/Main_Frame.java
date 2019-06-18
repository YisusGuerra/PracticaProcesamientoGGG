/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import image_management.ImageFilters;
import image_management.ImageManager;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.opencv.core.Mat;

/**
 *
 * @author devel
 */
public class Main_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Main_Fram
     */
    private static int lb_widht;
    private static int lb_height;
    private ImageManager img_manager;
    private ImageFilters img_filters;
    private Mat mat_original;
    private byte[] byte_original;
    private Mat m_tosave;
    private byte[] b_tosave;
    private String c_img_dir;
    int previo_br, previo_ct, previo_gm, previo_averg = 0;
    int actual_br, actual_ct, actual_gm, actual_averg = 0;

    public Main_Frame() {
        img_manager = new ImageManager();
        img_filters = new ImageFilters();
        initComponents();
        lb_widht = lb_img_edit.getWidth();
        lb_height = lb_img_edit.getHeight();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lb_img_orig = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Load_img = new javax.swing.JButton();
        Reset_img = new javax.swing.JButton();
        Save_img = new javax.swing.JButton();
        lb_img_edit = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Corrections = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        slider_bright = new javax.swing.JSlider();
        jPanel4 = new javax.swing.JPanel();
        slider_gamma = new javax.swing.JSlider();
        jPanel3 = new javax.swing.JPanel();
        slider_constrast = new javax.swing.JSlider();
        Check_neg = new javax.swing.JCheckBox();
        Chek_bin = new javax.swing.JCheckBox();
        Smoothing = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        slider_averging = new javax.swing.JSlider();
        jPanel8 = new javax.swing.JPanel();
        slider_gaussian = new javax.swing.JSlider();
        jPanel10 = new javax.swing.JPanel();
        slider_median = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_img_orig.setBorder(javax.swing.BorderFactory.createTitledBorder("Original"));

        Load_img.setText("Cargar Imagen");
        Load_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Load_imgActionPerformed(evt);
            }
        });

        Reset_img.setText("Reset");
        Reset_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reset_imgActionPerformed(evt);
            }
        });

        Save_img.setText("Guardar");
        Save_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_imgActionPerformed(evt);
            }
        });

        lb_img_edit.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen:"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Brillo"));

        slider_bright.setMajorTickSpacing(1);
        slider_bright.setMaximum(10);
        slider_bright.setMinimum(-10);
        slider_bright.setMinorTickSpacing(1);
        slider_bright.setPaintTicks(true);
        slider_bright.setSnapToTicks(true);
        slider_bright.setToolTipText("");
        slider_bright.setValue(0);
        slider_bright.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_brightStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_bright, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_bright, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Gamma"));

        slider_gamma.setMajorTickSpacing(1);
        slider_gamma.setMaximum(10);
        slider_gamma.setMinorTickSpacing(1);
        slider_gamma.setPaintTicks(true);
        slider_gamma.setSnapToTicks(true);
        slider_gamma.setToolTipText("");
        slider_gamma.setValue(0);
        slider_gamma.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_gammaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_gamma, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(slider_gamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraste"));

        slider_constrast.setMajorTickSpacing(1);
        slider_constrast.setMaximum(10);
        slider_constrast.setMinimum(-10);
        slider_constrast.setMinorTickSpacing(1);
        slider_constrast.setPaintTicks(true);
        slider_constrast.setToolTipText("");
        slider_constrast.setValue(0);
        slider_constrast.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_constrastStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_constrast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_constrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Check_neg.setText("Negativo");
        Check_neg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Check_negMouseClicked(evt);
            }
        });

        Chek_bin.setText("Binario");
        Chek_bin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chek_binMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CorrectionsLayout = new javax.swing.GroupLayout(Corrections);
        Corrections.setLayout(CorrectionsLayout);
        CorrectionsLayout.setHorizontalGroup(
            CorrectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CorrectionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CorrectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CorrectionsLayout.createSequentialGroup()
                        .addGroup(CorrectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CorrectionsLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Check_neg)
                                .addGap(18, 18, 18)
                                .addComponent(Chek_bin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CorrectionsLayout.setVerticalGroup(
            CorrectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CorrectionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CorrectionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Check_neg)
                    .addComponent(Chek_bin))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Corrections", Corrections);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Averging"));

        slider_averging.setMajorTickSpacing(1);
        slider_averging.setMaximum(10);
        slider_averging.setMinorTickSpacing(1);
        slider_averging.setPaintTicks(true);
        slider_averging.setSnapToTicks(true);
        slider_averging.setToolTipText("");
        slider_averging.setValue(0);
        slider_averging.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_avergingStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_averging, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(slider_averging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Gaussian"));

        slider_gaussian.setMajorTickSpacing(1);
        slider_gaussian.setMaximum(10);
        slider_gaussian.setMinorTickSpacing(1);
        slider_gaussian.setPaintTicks(true);
        slider_gaussian.setSnapToTicks(true);
        slider_gaussian.setToolTipText("");
        slider_gaussian.setValue(0);
        slider_gaussian.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_gaussianStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_gaussian, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(slider_gaussian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Median"));

        slider_median.setMajorTickSpacing(1);
        slider_median.setMaximum(10);
        slider_median.setMinorTickSpacing(1);
        slider_median.setPaintTicks(true);
        slider_median.setSnapToTicks(true);
        slider_median.setToolTipText("");
        slider_median.setValue(0);
        slider_median.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_medianStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider_median, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(slider_median, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout SmoothingLayout = new javax.swing.GroupLayout(Smoothing);
        Smoothing.setLayout(SmoothingLayout);
        SmoothingLayout.setHorizontalGroup(
            SmoothingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SmoothingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SmoothingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SmoothingLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SmoothingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(SmoothingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        SmoothingLayout.setVerticalGroup(
            SmoothingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SmoothingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Smooothing", Smoothing);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Load_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Reset_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Save_img, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_img_orig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lb_img_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_img_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_img_orig, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Load_img)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Reset_img)
                            .addComponent(Save_img))
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Load_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Load_imgActionPerformed
        // TODO add your handling code here:
        try {
            mat_original = img_manager.loadImage();
            byte_original = img_manager.toBytes(mat_original);
        } catch (Exception e) {
            System.out.println("Algo salió mal, aiuda");
        } finally {
            setUp(mat_original, byte_original);
        }
    }//GEN-LAST:event_Load_imgActionPerformed

    private void Reset_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reset_imgActionPerformed
        // TODO add your handling code here:
        restart();
    }//GEN-LAST:event_Reset_imgActionPerformed

    private void Save_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_imgActionPerformed
        // TODO add your handling code here:
        try {
            int var = 0;
            JFileChooser chooser = new JFileChooser("D:/Escritorio");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showDialog(null, null);
            try {
                File outpufile = new File(chooser.getSelectedFile().toString() + "/image_" + var + ".jpg");
                while (outpufile.exists()) {
                    var++;
                    outpufile = new File(chooser.getSelectedFile().toString() + "/image_" + var + ".jpg");
                }
                ImageIO.write(img_manager.toRenderedImage((BufferedImage) img_manager.toBufferedImage(m_tosave, b_tosave)), "jpg", outpufile);
            } catch (IOException ex) {
                System.out.println("Error al guardar la Imagen");
            }
        } catch (HeadlessException ex) {

        }
    }//GEN-LAST:event_Save_imgActionPerformed

    private void Check_negMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Check_negMouseClicked
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        if (Check_neg.isSelected()) {
            try {
                e_mat = img_filters.negative(byte_original, mat_original);
                e_byte = img_manager.toBytes(e_mat);
            } catch (Exception e) {
            } finally {
                changeImg(e_mat, e_byte);
            }
            m_tosave = e_mat;
            b_tosave = e_byte;
        } else {
            restart();
        }
    }//GEN-LAST:event_Check_negMouseClicked

    private void Chek_binMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chek_binMouseClicked
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        if (Chek_bin.isSelected()) {
            try {
                e_mat = img_filters.binarization(byte_original, mat_original);
                e_byte = img_manager.toBytes(e_mat);
            } catch (Exception e) {

            } finally {
                changeImg(e_mat, e_byte);
            }
            m_tosave = e_mat;
            b_tosave = e_byte;
        } else {
            restart();
        }
    }//GEN-LAST:event_Chek_binMouseClicked

    private void slider_constrastStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_constrastStateChanged
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        actual_ct = slider_constrast.getValue();
        try {
            if (actual_ct > previo_ct) {
                e_mat = img_filters.addContrast(byte_original, mat_original, actual_ct);
                e_byte = img_manager.toBytes(e_mat);
                previo_ct = actual_ct;
            } else {
                e_mat = img_filters.lessContrast(byte_original, mat_original, actual_ct);
                e_byte = img_manager.toBytes(e_mat);
                previo_ct = actual_ct;
            }
        } catch (Exception e) {
        } finally {
            changeImg(e_mat, e_byte);
        }
        m_tosave = e_mat;
        b_tosave = e_byte;
    }//GEN-LAST:event_slider_constrastStateChanged

    private void slider_gammaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_gammaStateChanged
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        actual_gm = slider_gamma.getValue();
        try {
            if (actual_gm > previo_gm) {
                e_mat = img_filters.addGamma(byte_original, mat_original, actual_gm);
                e_byte = img_manager.toBytes(e_mat);
                previo_gm = actual_gm;
            } else {

            }
        } catch (Exception e) {
        } finally {
            changeImg(e_mat, e_byte);
        }
        m_tosave = e_mat;
        b_tosave = e_byte;
    }//GEN-LAST:event_slider_gammaStateChanged

    private void slider_brightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_brightStateChanged
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        actual_br = slider_bright.getValue();
        try {
            if (actual_br > previo_br) {
                e_mat = img_filters.addBrightness(byte_original, mat_original, actual_br);
                e_byte = img_manager.toBytes(e_mat);
                previo_br = actual_br;
            } else {
                e_mat = img_filters.lessBrightness(byte_original, mat_original, slider_bright.getValue());
                e_byte = img_manager.toBytes(e_mat);
                previo_br = actual_br;
            }
        } catch (Exception e) {
        } finally {
            changeImg(e_mat, e_byte);
        }
        m_tosave = e_mat;
        b_tosave = e_byte;
    }//GEN-LAST:event_slider_brightStateChanged

    private void slider_avergingStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_avergingStateChanged
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        try {
            if (slider_averging.getValue() == 0) {
                e_mat = img_filters.avergingFilter(byte_original, mat_original);
                e_byte = img_manager.toBytes(e_mat);
            } else {
                e_mat = img_filters.avergingFilter(b_tosave, m_tosave);
                e_byte = img_manager.toBytes(e_mat);
            }
        } catch (Exception e) {
        } finally {
            changeImg(e_mat, e_byte);
        }
        m_tosave = e_mat;
        b_tosave = e_byte;
    }//GEN-LAST:event_slider_avergingStateChanged

    private void slider_gaussianStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_gaussianStateChanged
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        try {
            if (slider_gaussian.getValue() == 0) {
                e_mat = img_filters.gaussianFilter(byte_original, mat_original);
                e_byte = img_manager.toBytes(e_mat);
            } else {
                e_mat = img_filters.gaussianFilter(b_tosave, m_tosave);
                e_byte = img_manager.toBytes(e_mat);
            }
        } catch (Exception e) {
        } finally {
            changeImg(e_mat, e_byte);
        }
        m_tosave = e_mat;
        b_tosave = e_byte;
    }//GEN-LAST:event_slider_gaussianStateChanged

    private void slider_medianStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_medianStateChanged
        // TODO add your handling code here:
        Mat e_mat = null;
        byte[] e_byte = null;
        try {
            if (slider_median.getValue() == 0) {
                e_mat = img_filters.medianFilter(byte_original, mat_original);
                e_byte = img_manager.toBytes(e_mat);
            } else {
                e_mat = img_filters.medianFilter(b_tosave, m_tosave);
                e_byte = img_manager.toBytes(e_mat);
            }
        } catch (Exception e) {
            System.out.println("errrrooooorrr"
                    + "");
        }finally{
            changeImg(e_mat, e_byte);
        }
        m_tosave = e_mat;
        b_tosave = e_byte;
    }//GEN-LAST:event_slider_medianStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check_neg;
    private javax.swing.JCheckBox Chek_bin;
    private javax.swing.JPanel Corrections;
    private javax.swing.JButton Load_img;
    private javax.swing.JButton Reset_img;
    private javax.swing.JButton Save_img;
    private javax.swing.JPanel Smoothing;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_img_edit;
    private javax.swing.JLabel lb_img_orig;
    private javax.swing.JSlider slider_averging;
    private javax.swing.JSlider slider_bright;
    private javax.swing.JSlider slider_constrast;
    private javax.swing.JSlider slider_gamma;
    private javax.swing.JSlider slider_gaussian;
    private javax.swing.JSlider slider_median;
    // End of variables declaration//GEN-END:variables

    private void changeImg(Mat m, byte[] b) {
        try {
            lb_img_edit.setSize(lb_widht, lb_height);
            Image img = img_manager.toBufferedImage(m, b);
            lb_img_edit.setIcon(new ImageIcon(img.getScaledInstance(lb_img_edit.getWidth(), lb_img_edit.getHeight(), img.SCALE_DEFAULT)));
        } catch (Exception e) {
        }

    }

    private void setUp(Mat m, byte[] b) {
        try {
            Image img = img_manager.toBufferedImage(m, b);
            lb_img_edit.setIcon(new ImageIcon(img.getScaledInstance(lb_img_edit.getWidth(), lb_img_edit.getHeight(), img.SCALE_DEFAULT)));
            lb_img_orig.setIcon(new ImageIcon(img.getScaledInstance(lb_img_orig.getWidth(), lb_img_orig.getHeight(), img.SCALE_DEFAULT)));
        } catch (Exception e) {
        }
    }

    private void restart() {
        lb_img_edit.setIcon(null);
        lb_img_orig.setIcon(null);
        slider_bright.setValue(0);
        slider_constrast.setValue(0);
        slider_gamma.setValue(0);
        slider_averging.setValue(0);
        slider_gaussian.setValue(0);
        slider_median.setValue(0);
        try {
            mat_original = img_manager.loadImageDir();
            byte_original = img_manager.toBytes(mat_original);
        } catch (Exception e) {
        }
        setUp(mat_original, byte_original);
    }
}

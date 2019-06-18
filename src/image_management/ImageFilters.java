/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_management;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.opencv.core.Mat;

/**
 *
 * @author devel
 */
public class ImageFilters {

    public Mat addBrightness(byte bytes[], Mat image, int level) {
        if (level <= 0) {
            level = level * (-1);
        }
        double[] newSpec;
        for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                newSpec = image.get(i, j);
                newSpec[0] = newSpec[0] + level;
                newSpec[1] = newSpec[1] + level;
                newSpec[2] = newSpec[2] + level;
                image.put(i, j, newSpec);
            }
        }
        return image;
    }

    public Mat lessBrightness(byte bytes[], Mat image, int level) {
        if (level <= 0) {
            level = level * (-1);
        }
        double[] newSpec;
        for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                newSpec = image.get(i, j);
                newSpec[0] = newSpec[0] - level;
                newSpec[1] = newSpec[1] - level;
                newSpec[2] = newSpec[2] - level;
                image.put(i, j, newSpec);
            }
        }
        return image;
    }

    public Mat addContrast(byte bytes[], Mat m, int level) {
        if (level <= 0) {
            level = level * (-1);
        }
        double[] newSpec;
        int B = 127;
        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                newSpec = m.get(i, j);
                if (newSpec[0] >= B) {
                    newSpec[0] = newSpec[0] + level;
                } else {
                    newSpec[0] = newSpec[0] - level;
                }
                if (newSpec[1] >= B) {
                    newSpec[1] = newSpec[1] + level;
                } else {
                    newSpec[1] = newSpec[1] - level;
                }
                if (newSpec[2] >= B) {
                    newSpec[2] = newSpec[2] + level;
                } else {
                    newSpec[2] = newSpec[2] - level;
                }
                m.put(i, j, newSpec);
            }
        }
        return m;
    }

    public Mat lessContrast(byte bytes[], Mat m, int level) {
        if (level <= 0) {
            level = level * (-1);
        }
        double[] newSpec;
        int B = 127;
        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                newSpec = m.get(i, j);
                if (newSpec[0] > B) {
                    newSpec[0] = newSpec[0] - level;
                } else {
                    newSpec[0] = newSpec[0] + level;
                }
                if (newSpec[1] > B) {
                    newSpec[1] = newSpec[1] - level;
                } else {
                    newSpec[1] = newSpec[1] + level;
                }
                if (newSpec[2] > B) {
                    newSpec[2] = newSpec[2] - level;
                } else {
                    newSpec[2] = newSpec[2] + level;
                }
                m.put(i, j, newSpec);
            }
        }
        return m;
    }

    public Mat addGamma(byte bytes[], Mat m, int level) {
        if (level <= 0) {
            level = level * (-1);
        }
        double R = (level / 10.0);
        double[] newSpec;
        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                newSpec = m.get(i, j);
                newSpec[0] = newSpec[0] + pow(newSpec[0], R);
                newSpec[1] = newSpec[1] + pow(newSpec[1], R);
                newSpec[2] = newSpec[2] + pow(newSpec[2], R);
                m.put(i, j, newSpec);
            }
        }
        return m;
    }

    public Mat binarization(byte bytes[], Mat m) {
        double[] newSpec;
        double B = 127.0;
        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                newSpec = m.get(i, j);
                double mayor = 0.0;
                if (newSpec[0] > newSpec[1]) {
                    if (newSpec[1] > newSpec[2]) {
                        mayor = newSpec[0];
                    } else {
                        mayor = newSpec[2];
                    }
                } else {
                    if (newSpec[1] > newSpec[2]) {
                        mayor = newSpec[1];
                    } else {
                        mayor = newSpec[2];
                    }
                }
                if (mayor < B) {
                    newSpec[0] = 0;
                    newSpec[1] = 0;
                    newSpec[2] = 0;
                } else {
                    newSpec[0] = 255;
                    newSpec[1] = 255;
                    newSpec[2] = 255;
                }
                m.put(i, j, newSpec);
            }
        }
        return m;
    }

    public Mat negative(byte bytes[], Mat m) {
        double[] newSpec;
        for (int i = 0; i < m.rows(); i++) {
            for (int j = 0; j < m.cols(); j++) {
                newSpec = m.get(i, j);
                newSpec[0] = 255 - newSpec[0];
                newSpec[1] = 255 - newSpec[1];
                newSpec[2] = 255 - newSpec[2];
                m.put(i, j, newSpec);
            }
        }
        return m;
    }

    public Mat avergingFilter(byte bytes[], Mat m) {
        double newSpec[];
        Mat re = m.clone();
        for (int i = 1; i < m.rows() - 1; i++) {
            for (int j = 1; j < m.cols() - 1; j++) {
                newSpec = m.get(i, j);
                newSpec[0] = (newSpec[0] / 9.0) + ((m.get(i - 1, j - 1)[0]) / 9.0) + ((m.get(i - 1, j)[0]) / 9.0)
                        + ((m.get(i - 1, j + 1)[0]) / 9.0) + ((m.get(i, j - 1)[0]) / 9.0) + ((m.get(i, j + 1)[0]) / 9.0)
                        + ((m.get(i + 1, j - 1)[0]) / 9.0) + ((m.get(i + 1, j)[0]) / 9.0) + ((m.get(i + 1, j + 1)[0]) / 9.0);
                newSpec[1] = (newSpec[1] / 9.0) + ((m.get(i - 1, j - 1)[1]) / 9.0) + ((m.get(i - 1, j)[1]) / 9.0)
                        + ((m.get(i - 1, j + 1)[1]) / 9.0) + ((m.get(i, j - 1)[1]) / 9.0) + ((m.get(i, j + 1)[1]) / 9.0)
                        + ((m.get(i + 1, j - 1)[1]) / 9.0) + ((m.get(i + 1, j)[1]) / 9.0) + ((m.get(i + 1, j + 1)[1]) / 9.0);
                newSpec[2] = (newSpec[2] / 9.0) + ((m.get(i - 1, j - 1)[2]) / 9.0) + ((m.get(i - 1, j)[2]) / 9.0)
                        + ((m.get(i - 1, j + 1)[2]) / 9.0) + ((m.get(i, j - 1)[2]) / 9.0) + ((m.get(i, j + 1)[2]) / 9.0)
                        + ((m.get(i + 1, j - 1)[2]) / 9.0) + ((m.get(i + 1, j)[2]) / 9.0) + ((m.get(i + 1, j + 1)[2]) / 9.0);
                re.put(i, j, newSpec);
            }
        }
        return re;
    }

    public Mat gaussianFilter(byte bytes[], Mat m) {
        double newSpec[];
        Mat re = m.clone();
        for (int i = 1; i < m.rows() - 1; i++) {
            for (int j = 1; j < m.cols() - 1; j++) {
                newSpec = m.get(i, j);
                newSpec[0] = (newSpec[0] / 4.0) + ((m.get(i - 1, j - 1)[0]) / 16.0) + ((m.get(i - 1, j)[0]) / 8.0)
                        + ((m.get(i - 1, j + 1)[0]) / 16.0) + ((m.get(i, j - 1)[0]) / 8.0) + ((m.get(i, j + 1)[0]) / 8.0)
                        + ((m.get(i + 1, j - 1)[0]) / 16.0) + ((m.get(i + 1, j)[0]) / 8.0) + ((m.get(i + 1, j + 1)[0]) / 16.0);
                newSpec[1] = (newSpec[1] / 4.0) + ((m.get(i - 1, j - 1)[1]) / 16.0) + ((m.get(i - 1, j)[1]) / 8.0)
                        + ((m.get(i - 1, j + 1)[1]) / 16.0) + ((m.get(i, j - 1)[1]) / 8.0) + ((m.get(i, j + 1)[1]) / 8.0)
                        + ((m.get(i + 1, j - 1)[1]) / 16.0) + ((m.get(i + 1, j)[1]) / 8.0) + ((m.get(i + 1, j + 1)[1]) / 16.0);
                newSpec[2] = (newSpec[2] / 4.0) + ((m.get(i - 1, j - 1)[2]) / 16.0) + ((m.get(i - 1, j)[2]) / 8.0)
                        + ((m.get(i - 1, j + 1)[2]) / 16.0) + ((m.get(i, j - 1)[2]) / 8.0) + ((m.get(i, j + 1)[2]) / 8.0)
                        + ((m.get(i + 1, j - 1)[2]) / 16.0) + ((m.get(i + 1, j)[2]) / 8.0) + ((m.get(i + 1, j + 1)[2]) / 16.0);
                re.put(i, j, newSpec);
            }
        }
        return re;
    }

    public Mat medianFilter(byte bytes[], Mat m) {
        double newSpec[];
        Mat re = m.clone();
        int c1 = 0, c2 = 0, c3 = 0;
        double[] B = new double[9],
                G = new double[9],
                R = new double[9];
        for (int i = 1; i < m.rows() - 1; i++) {
            for (int j = 1; j < m.cols() - 1; j++) {
                newSpec = m.get(i, j);
                while (c1 < 8) {
                    B[c1] = (newSpec[0]);
                    c1++;
                    B[c1] = (m.get(i - 1, j - 1)[0]);
                    c1++;
                    B[c1] = (m.get(i - 1, j)[0]);
                    c1++;
                    B[c1] = (m.get(i - 1, j + 1)[0]);
                    c1++;
                    B[c1] = (m.get(i, j - 1)[0]);
                    c1++;
                    B[c1] = (m.get(i, j + 1)[0]);
                    c1++;
                    B[c1] = (m.get(i + 1, j - 1)[0]);
                    c1++;
                    B[c1] = (m.get(i + 1, j)[0]);
                    c1++;
                    B[c1] = (m.get(i + 1, j + 1)[0]);
                    c1++;
                }
                while (c2 < 8) {
                    G[c2] = (newSpec[1]);
                    c2++;
                    G[c2] = (m.get(i - 1, j - 1)[1]);
                    c2++;
                    G[c2] = (m.get(i - 1, j)[1]);
                    c2++;
                    G[c2] = (m.get(i - 1, j + 1)[1]);
                    c2++;
                    G[c2] = (m.get(i, j - 1)[1]);
                    c2++;
                    G[c2] = (m.get(i, j + 1)[1]);
                    c2++;
                    G[c2] = (m.get(i + 1, j - 1)[1]);
                    c2++;
                    G[c2] = (m.get(i + 1, j)[1]);
                    c2++;
                    G[c2] = (m.get(i + 1, j + 1)[1]);
                    c2++;
                }
                while (c3 < 8) {
                    R[c3] = (newSpec[2]);
                    c3++;
                    R[c3] = (m.get(i - 1, j - 1)[2]);
                    c3++;
                    R[c3] = (m.get(i - 1, j)[2]);
                    c3++;
                    R[c3] = (m.get(i - 1, j + 1)[2]);
                    c3++;
                    R[c3] = (m.get(i, j - 1)[2]);
                    c3++;
                    R[c3] = (m.get(i, j + 1)[2]);
                    c3++;
                    R[c3] = (m.get(i + 1, j - 1)[2]);
                    c3++;
                    R[c3] = (m.get(i + 1, j)[2]);
                    c3++;
                    R[c3] = (m.get(i + 1, j + 1)[2]);
                    c3++;
                }
                Arrays.sort(B);
                Arrays.sort(G);
                Arrays.sort(R);
                newSpec[0] = B[4];
                newSpec[1] = G[4];
                newSpec[2] = R[4];
                c1 = 0;
                c2 = 0;
                c3 = 0;
                re.put(i, j, newSpec);
            }
        }
        return re;
    }

}

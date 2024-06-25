package org.kakao20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P5_1_Installation_of_Pillars_and_Beams {
    static class Pillow {
        int[] bottom;
        int[] top;
        List<Pillow> pillows;
        List<Beam> beams;

        public Pillow(int[] bottom, int[] top) {
            this.bottom = bottom;
            this.top = top;
            this.pillows = new ArrayList<>();
            this.beams = new ArrayList<>();
        }

        public void addPillow(Pillow pillow) {
            pillows.add(pillow);
        }
    }

    static class Pillows {
        List<Pillow> pillows;

        public Pillows(List<Pillow> pillows) {
            this.pillows = pillows;
        }

        public void add(Pillow pillow) {
            pillows.add(pillow);
        }

        public boolean isOnPillow(int row, int col) {
            for (Pillow p : pillows) {
                if (p.top[0] == row && p.top[1] == col) {
                    return true;
                }
            }
            return false;
        }

        public Pillow getBasePillow(int row, int col) {
            for (Pillow p : pillows) {
                if (p.top[0] == row && p.top[1] == col) {
                    return p;
                }
            }
            return null;
        }

        public List<Pillow> getPillows() {
            return pillows;
        }



    }

    static class Beam {
        int[] left;
        int[] right;
        List<Pillow> pillows;
        List<Beam> beams;

        public Beam(int[] left, int[] right) {
            this.left = left;
            this.right = right;
            this.pillows = new ArrayList<>();
            this.beams = new ArrayList<>();
        }
    }

    static class Beams {
        List<Beam> beams;

        public Beams(List<Beam> beams) {
            this.beams = beams;
        }

        public void add(Beam beam) {
            beams.add(beam);
        }

        public boolean isOnPillow(Pillows pillows, int row, int col) {
            return pillows.isOnPillow(row + 1, col) || pillows.isOnPillow(row, col);
        }

        public List<Pillow> getBasePillows(Pillows pillows, int row, int col) {
            List<Pillow> basedPillows = new ArrayList<>();
            if (pillows.isOnPillow(row + 1, col)) {
                basedPillows.add(pillows.getBasePillow(row + 1, col));
            }
            if (pillows.isOnPillow(row, col)) {
                basedPillows.add(pillows.getBasePillow(row, col));
            }
            return basedPillows;
        }

        public boolean isBetweenBeams(int row, int col) {
            return hasLeft(row, col) && hasRight(row, col + 1);
        }

        public boolean hasLeft(int row, int col) {
            for (Beam beam : beams) {
                if (beam.right[0] == row && beam.right[1] == col) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasRight(int row, int col) {
            for (Beam beam : beams) {
                if (beam.left[0] == row && beam.left[1] == col) {
                    return true;
                }
            }
            return false;
        }

        public Beam getLeftFrom(int row, int col) {
            for (Beam beam : beams) {
                if (beam.right[0] == row && beam.right[1] == col) {
                    return beam;
                }
            }
            return null;
        }

        public Beam getRightFrom(int row, int col) {
            for (Beam beam : beams) {
                if (beam.left[0] == row && beam.left[1] == col) {
                    return beam;
                }
            }
            return null;
        }
    }

    // 1. Build the pillows and the beams after checking conditions
    // 2. Remove the pillows and the beams after checking conditions
    // 3. Combine the pillows and the beams then sort them.
    public int[][] solution(int n, int[][] build_frame) {

        Pillows pillows = new Pillows(new ArrayList<>());
        Beams beams = new Beams(new ArrayList<>());

        for (int[] frame : build_frame) {
            // 1. In case of construction
            if (frame[3] == 1) {
                // In case of a pillow
                if (frame[2] == 0) {
                    // In case when the point is on bottom
                    if (frame[1] == 0 ) {
                        pillows.add(new Pillow(
                                new int[]{frame[0], frame[1]},
                                new int[]{frame[0], frame[1] + 1}
                        ));
                    // In case when the point is on a pillow
                    } else if (pillows.isOnPillow(frame[0], frame[1])) {
                        Pillow pillow = new Pillow(
                                new int[]{frame[0], frame[1]},
                                new int[]{frame[0], frame[1] + 1}
                        );
                        Pillow basePillow = pillows.getBasePillow(frame[0], frame[1]);
                        pillow.addPillow(basePillow);
                        pillows.add(pillow);
                    }


                // In case of a beam
                } else if (frame[2] == 1) {
                    Beam beam = new Beam(
                            new int[]{frame[0], frame[1]},
                            new int[]{frame[0], frame[1] + 1}
                    );

                    if (beams.isOnPillow(pillows, frame[0], frame[1])) {
                        List<Pillow> basedPillows = beams.getBasePillows(pillows, frame[0], frame[1]);

                        beam.pillows.addAll(basedPillows);

                        beams.add(beam);

                    } else if (beams.isBetweenBeams(frame[0], frame[1])) {
                        List<Beam> basedBeams = new ArrayList<>();

                        if (beams.hasLeft(frame[0], frame[1])) {
                            basedBeams.add(beams.getLeftFrom(frame[0], frame[1]));
                        }
                        if (beams.hasRight(frame[0] + 1, frame[1])) {
                            basedBeams.add(beams.getRightFrom(frame[0], frame[1]));
                        }

                        beam.beams.addAll(basedBeams);

                        beams.add(beam);
                    }
                }
            // 2.  In case of removal
            } else if (frame[3] == 0){

            }
        }

//        for (Pillow p : pillows.pillows) {
//            System.out.println(Arrays.toString(new int[]{p.bottom[0], p.bottom[1]}));
//        }
//
//        for (Beam b : beams.beams) {
//            System.out.println(Arrays.toString(new int[]{b.left[0], b.left[1]}));
//            System.out.println(Arrays.toString(b.pillows.get(0).bottom));
//            System.out.println(b.beams);
//            System.out.println("---");
//        }


        return null;
    }


}

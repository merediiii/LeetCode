//
// This example program reads a .binvox file and writes
// a text file (with Java 2-byte characters) version of the same file called "voxels.txt"
//
// 0 = empty voxel
// 1 = filled voxel
// A newline is output after every "dim" voxels (depth = height = width = dim)
//
// Note that this text file format is not supported by "viewvox" and "thinvox"
//
// The x-axis is the most significant axis, then the z-axis, then the y-axis.
//

import java.io.*;


public class ReadBinvox {
    private static byte[] voxels;
    private static int depth, height, width;
    private static int size;
    private static double tx, ty, tz;
    private static double scale;


    public static boolean read_binvox(String filespec) throws Exception {
        FileInputStream binvox_file = new FileInputStream(filespec);
        DataInputStream binvox_data = new DataInputStream(binvox_file);

        //
        // read header
        //
        String line = binvox_data.readLine();  // deprecated function though
        if (!line.startsWith("#binvox")) {
            System.out.println("Error: first line reads [" + line + "] instead of [#binvox]");
            return false;
        }

        String version_string = line.substring(8);
        int version = Integer.parseInt(version_string);
        System.out.println("reading binvox version " + version);

        depth = height = width = 0;
        boolean done = false;

        while (!done) {

            line = binvox_data.readLine();

            if (line.startsWith("data")) done = true;
            else {
                System.out.println(line);
                if (line.startsWith("dim")) {
                    String[] dimensions = line.split(" ");
                    depth = Integer.parseInt(dimensions[1]);
                    height = Integer.parseInt(dimensions[2]);
                    width = Integer.parseInt(dimensions[3]);
                } else {
                    if (line.startsWith("translate")) {
                        // tx = binvox_data.readDouble();
                        // ty = binvox_data.readDouble();
                        // tz = binvox_data.readDouble();
                    } else {
                        if (line.startsWith("scale")) {
                            // scale = binvox_data.readDouble();
                        } else {
                            System.out.println("  unrecognized keyword [" + line + "], skipping");
                        }
                    }
                }
            }
        }  // while

        if (!done) {
            System.out.println("  error reading header");
            return false;
        }
        if (depth == 0) {
            System.out.println("  missing dimensions in header");
            return false;
        }

        size = width * height * depth;
        voxels = new byte[size];

        //
        // read voxel data
        //
        byte value;
        int count;
        int index = 0;
        int end_index = 0;
        int nr_voxels = 0;

        // *input >> value;  // read the linefeed char

        while (end_index < size) {

            value = binvox_data.readByte();
            // idiotic Java language doesn't have unsigned types, so we have to use an int for 'count'
            // and make sure that we don't interpret it as a negative number if bit 7 (the sign bit) is on
            count = binvox_data.readByte() & 0xff;

            end_index = index + count;
            if (end_index > size) return false;
            for (int i = index; i < end_index; i++) voxels[i] = value;

            if (value > 0) nr_voxels += count;
            index = end_index;

        }  // while

        System.out.println("  read " + nr_voxels + " voxels");
        return true;

    }  // read_binvox


    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.out.println("Usage: read_binvox <binvox filename>");
//            System.exit(1);
//        }
//
//        if (!read_binvox(args[0])) {
//            System.out.println("Error reading [" + args[0] + "]");
//            System.exit(1);
//        }

        read_binvox("01.binvox");

        //
        // now write the data to as Java characters
        //
//        FileOutputStream out = new FileOutputStream("voxels.txt");
//        DataOutputStream data_out = new DataOutputStream(out);
//
//        System.out.println("Writing voxel data to a text file [voxels.txt]...");
//
//        data_out.writeChars("#binvox Java character data\n");
//        data_out.writeChars("dim ");
//        data_out.writeChars(new Integer(depth).toString());  // more Java bloat
//        data_out.writeChar(' ');
//        data_out.writeChars(new Integer(height).toString());
//        data_out.writeChar(' ');
//        data_out.writeChars(new Integer(width).toString());
//        data_out.writeChars("\n");
//
//        data_out.writeChars("data\n");
//
//        for (int i = 0; i < size; i++) {
//            if (voxels[i] == 1) data_out.writeChar('1');
//            else data_out.writeChar('0');
//            if (((i + 1) % width) == 0) data_out.writeChars("\n");
//        }  // for
//
//        data_out.close();
//
//        System.out.println("done");
//        System.out.println();

    }  // main

}



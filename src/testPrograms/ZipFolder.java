package testPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Zips an entire folder/package for DS. Will be named after the name of the first file in the package.
 */
public class ZipFolder {

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("What is the folder you wish to zip?\n\nAvailable Folders:");
            for (var s : new File("src").list())
                System.out.println("    " + s);
            String folder = input.nextLine();
            File srcFolder = new File("src/" + folder);
            File destZipFile = new File(srcFolder, String.format("/Kalia%s.zip", srcFolder.list()[0].split("\\.")[0]));
            ZipFolder.zipFolder(srcFolder, destZipFile);
        }
    }

    public static void zipFolder(File srcFolder, File destZipFile) throws Exception {
        try (FileOutputStream fileWriter = new FileOutputStream(destZipFile);
                ZipOutputStream zip = new ZipOutputStream(fileWriter)) {
            addFolderToZip(srcFolder, srcFolder, zip);
        }
    }

    private static void addFileToZip(File rootPath, File srcFile, ZipOutputStream zip) throws Exception {

        if (srcFile.isDirectory()) {
            addFolderToZip(rootPath, srcFile, zip);
        } else if (!srcFile.getAbsolutePath().contains(".zip")){
            byte[] buf = new byte[1024];
            int len;
            try (FileInputStream in = new FileInputStream(srcFile)) {
                String name = srcFile.getName();
                System.out.println("Zip " + srcFile + "\n to " + name);
                zip.putNextEntry(new ZipEntry(name));
                while ((len = in.read(buf)) > 0) {
                    zip.write(buf, 0, len);
                }
            }
        }
    }

    private static void addFolderToZip(File rootPath, File srcFolder, ZipOutputStream zip) throws Exception {
        for (File fileName : srcFolder.listFiles()) {
            addFileToZip(rootPath, fileName, zip);
        }
    }

    // should be store the file paths in an list, create a zip file; then for each file, add to the zip. See nio api
}
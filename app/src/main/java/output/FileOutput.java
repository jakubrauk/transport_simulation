package output;

import vehicles.Vehicle;
import world.World;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Class responsible for generating CSV files containing basic data about vehicles in simulation;
 * line: vehicle_id,vehicle_type,fields_moved,amount_of_goods,initial_amount,current_money
 */
public class FileOutput {
    /**
     * output filepath
     */
    final String filepath = "./csv_output_files/";
    final String file_extension = ".csv";

    /**
     * Returns line for csv file
     * @param v Vehicle instance
     * @return (basic vehicle data) vehicle_id,vehicle_type,fields_moved,amount_of_goods,initial_amount,current_money
     */
    private String getVehicleCSVLine(Vehicle v) {
        return v.getId()+","+v.getType()+","+v.getFieldsMoved()+","+v.getCurrentAmountOfGoods()+","+v.getInitialMoney()+","+v.getMoney();
    }

    /**
     * Saves CSV output file
     * @param filename filename
     * @param world World instance, from where to gather data (specified.
     */
    public void saveOutputFile(String filename, World world){
        try {
            FileWriter fw = new FileWriter(this.filepath + filename + this.file_extension, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (Vehicle v : world.getSortedListOfVehicles()) {
                pw.println(this.getVehicleCSVLine(v));
            }
            pw.flush();
            pw.close();
            System.out.println("FILE SAVED");
        } catch (Exception E) {
            System.out.println("Failed to save file.");
        }
    }
}

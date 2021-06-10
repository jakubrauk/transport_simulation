package output;

import vehicles.Vehicle;
import world.World;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileOutput {
    final String filepath = "./csv_output_files/";
    final String file_extension = ".csv";
    // after simulation start
    // after every data checkpoint
    // after end of simulation
    // WHAT TO SAVE?:
    // vehicle_id,vehicle_type,fields_moved,amount_of_goods,initial_amount,current_money
    // vehicle_id is not set yet. Also need to write ordering vehicles by id.

    private String getVehicleCSVLine(Vehicle v) {
        return v.getId()+","+v.getType()+","+v.getFieldsMoved()+","+v.getCurrentAmountOfGoods()+","+v.getInitialMoney()+","+v.getMoney();
    }
    public void saveOutputFile(String filename, World world){
        try {
            FileWriter fw = new FileWriter(this.filepath + filename + this.file_extension, true);
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

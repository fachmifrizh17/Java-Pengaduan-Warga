/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;


public class session {
    private static int u_id;
    private static String u_username;
    private static String u_nik;
    private static String u_id_warga;
     
    public static int getU_id() {
        return u_id;
    }
 
    public static void setU_id(int u_id) {
        session.u_id = u_id;
    }
 
    public static String getU_username() {
        return u_username;
    }
 
    public static void setU_username(String u_username) {
        session.u_username = u_username;
    }
 
    public static String getU_nik() {
        return u_nik;
    }
 
    public static void setU_nik(String u_nik) {
        session.u_nik = u_nik;
    }
    
    public static String getU_id_warga() {
        return u_id_warga;
    }

    public static void setU_id_warga(String u_id_warga) {
        session.u_id_warga = u_id_warga;
    }
}

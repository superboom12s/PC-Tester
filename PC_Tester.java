import javax.swing.*;

public class PC_Tester {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();

        final String MDC = "You are about to run \"PC Tester\"\n\nThis program may lag and overheat your computer\nwith the purpose of checking your PC speed.\n\nThe third option may take very long in some devices,\ndont worry if it takes several minutes, its working.\n\n\nIf you want to continue, select a mode:\n1: Fast and light, but not very acurate.\n2: Heavier than the first mode, but more curate\n3: Very heavy and slow, but very acurate.\n\n4: Custom Mode (use it only if you know what you are doing)\n\n\nIf you want to cancel, close this window or enter anything else.\n\nThis window will close when continuing,\nwait for the next one to open and\nthrowing result.\nYou can open your task manager (Windows) with\nctrl + shift + esc to see whats your\nPC performance.\n";
        final String MC = "CUSTOM MODE\n\n\nEnter how many times you want to repeat the sequence:\n";
        final String MC2 = "CUSTOM MODE\n\n\nWhat mode should run now?\n\n1: Light mode\n2: Heavy mode\n\nAnything else: Cancel";


        String continuar = JOptionPane.showInputDialog(jFrame, MDC, "", JOptionPane.WARNING_MESSAGE);

        long tiempoInicio = 0;
        try {
            if (continuar.equals("1") || continuar.equals("2") || continuar.equals("3")) {
                tiempoInicio = System.currentTimeMillis();
            }
        } catch (Exception e){
            cancel();
        }


        //"Fast and light"
        if (continuar.equals("1")) {

            for (int i = 0; i <= 300; i++) {
                ciclo_suave(i, 55555555);

                //25140 - Clase
                //
            }

        //"Heavier than the first mode and more accurate"
        } else if (continuar.equals("2")) {

            for (int i = 0; i <= 500; i++) {
                ciclo_suave(i, 99999999);

                //66232 - Clase
                //

            }

        //"Heavy and slow, but very accurate"
        } else if (continuar.equals("3")) {

            for (int i = 0; i <= 5000; i++) {
                ciclo_pesado(i);

                //740000 - Clase
                //
            }


        } else if (continuar.equals("4")){

            String custom1 = JOptionPane.showInputDialog(jFrame, MC, "", JOptionPane.QUESTION_MESSAGE);

            try {
                //transformar en entero
                Integer.parseInt(custom1);

            } catch (Exception e){
                cancel();
            }

            String custom2 = JOptionPane.showInputDialog(jFrame, MC2, "", JOptionPane.QUESTION_MESSAGE);

            tiempoInicio = System.currentTimeMillis();

            if(custom2.equals("1")){
                for(int i = 0; i == Integer.parseInt(custom1); i++){
                    ciclo_suave(i, Integer.parseInt(custom1));
                }
            }else if(custom2.equals("2")){
                for(int i = 0; i == Integer.parseInt(custom1); i++){
                    ciclo_pesado(i);
                }
            }else{
                cancel();
            }

        //Nothing entered or it has been canceled
        } else {
            cancel();
        }

        //If some of the processes has been selected, this will check the time it has been used to complete it.
        if (continuar.equals("1") || continuar.equals("2") || continuar.equals("3") || continuar.equals("4")) {

            long tiempoFin = System.currentTimeMillis();

            JOptionPane.showMessageDialog(null, "Test finished.\n\nCompleted in " + String.valueOf(tiempoFin - tiempoInicio) + " Miliseconds.\n(" + String.valueOf((tiempoFin - tiempoInicio) / 1000) + " seconds)", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //Lag Process (Light version)
    public static void ciclo_suave(int loopVal, int totalSpace) {

        String[] lagstring = new String[totalSpace];

        String actualLag = String.valueOf(Math.sqrt(Math.sqrt(Math.floor(Math.random() * 1000000000))));
        lagstring[loopVal] = actualLag;
        
    }

    //Lag Process (Heavy version)
    public static void ciclo_pesado(int loopVal) {

        String[] lagstring = new String[99999999];


        String actualLag = String.valueOf(Math.pow(Math.floor(Math.random() * 1000000000), 1/Math.floor(Math.random() * 1000000000)) / Math.pow(Math.floor(Math.random() * 1000000000), 1/Math.floor(Math.random() * 1000000000)));
        lagstring[loopVal] = actualLag;


        if(lagstring[loopVal]==""){}


    }

    public static void cancel(){
        System.out.println("Operation cancelled.");
        JOptionPane.showMessageDialog(null, "Operation cancelled.", "", JOptionPane.ERROR_MESSAGE);
    }
}

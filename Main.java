import java.util.Scanner;

public class Main {

    public static boolean validarNombre(String nombre) {

        //No valen espacio
        if (nombre.length()!=nombre.trim().length()) return false;

        //No valen numeros
        for (int i = 0; i < nombre.length(); i++) {

            if (Character.isDigit(nombre.charAt(i))) return false;

        }

        //El primer caracter debe ser mayuscula
        if (!Character.isUpperCase(nombre.charAt(0))) return false;

        //El resto de caracteres deben ser minuscula
        if (!nombre.substring(1).equals(nombre.substring(1).toLowerCase())) return false;

        return true;

    }

    public static boolean validarDescripcion(String descripcion) {

        //No valen espacios
        if (!descripcion.equals(descripcion.trim())) return false;

        //No valen numeros
        for (int i = 0; i < descripcion.length(); i++) {

            if (!Character.isLetter(descripcion.charAt(i))) return false;

        }

        //Todos los caracteres deben estar en mayuscula
        for (int i = 0; i < descripcion.length(); i++) {

            if (!Character.isUpperCase(descripcion.charAt(i))) return false;
            
        }

        return true;

    }

    public static boolean validarDni(String dni) {

        //No valen espacios
        if (!dni.equals(dni.trim())) return false;

        //Tiene que ser longitud 9
        if (dni.length() != 9) return false;

        //El ultimo caracter debe estar en mayusula
        if (!Character.isUpperCase(dni.charAt(dni.length() -1))) return false;

        //El resto de caracteres deben ser digitos
        for (int i = 0; i < dni.length() -1; i++) {

            if (!Character.isDigit(dni.charAt(i))) return false;
            
        }

        return true;

    }

    public static boolean validarCodigo(String codigo) {

        //No valen espacio
        if (!codigo.equals(codigo.trim())) return false;

        //Deben tener longitud 6
        if (codigo.length() != 6) return false;

        //Los dos primeros caracteres deben estar en mayúsculas.
        for (int i = 0; i <= 1; i++) {

            if (!Character.isUpperCase(codigo.charAt(i))) return false;
            
        }

        //El resto deben ser números.
        for (int j = 2; j < codigo.length() -1; j++) {

            if (!Character.isDigit(codigo.charAt(j))) return false;

        }

        return true;

    }

    public static boolean validarFecha(String fecha) {

        //No valen espacios
        if (!fecha.equals(fecha.trim())) return false;

        //Debe tener longitud 10
        if (fecha.length() != 10) return false;

        //Debe seguir el formato "dd/mm/yyyy" controlando las barras, que el día esté entre 1 y 31 y el mes entre 1 y 12.
        //DIA
        char dtmp0 = fecha.charAt(0);
        char dtmp1 = fecha.charAt(1);
        String dia1 = String.valueOf(dtmp0);
        String dia2 = String.valueOf(dtmp1);
        String diaf = dia1.concat(dia2);
        int dia = Integer.parseInt(diaf);

        //Mes
        char mtmp0 = fecha.charAt(3);
        char mtmp1 = fecha.charAt(4);
        String mes1 = String.valueOf(mtmp0);
        String mes2 = String.valueOf(mtmp1);
        String mesf = mes1.concat(mes2);
        int mes = Integer.parseInt(mesf);

        //Año
        char ytmp0 = fecha.charAt(6);
        char ytmp1 = fecha.charAt(7);
        char ytmp2 = fecha.charAt(8);
        char ytmp3 = fecha.charAt(9);
        String year1 = String.valueOf(ytmp0);
        String year2 = String.valueOf(ytmp1);
        String year3 = String.valueOf(ytmp2);
        String year4 = String.valueOf(ytmp3);
        String yearf1 = year1.concat(year2);
        String yearf2 = year2.concat(year4);
        String yearf3 = yearf1.concat(yearf2);
        int year = Integer.parseInt(yearf3);

        if (fecha .charAt(2) != '/' || fecha.charAt(5) != '/') return false;

        for (int i = 0; i < fecha.length(); i++) {

            if (!Character.isDigit(fecha.charAt(i))) return false;

            if (i == 1 || i == 4) i++;
            
        }

        if ((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (year < 1)) return false;

        return true;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombre;
        String descripcion;
        String dni;
        String codigo;
        String fecha;

        do {

            System.out.print("Introduce un nombre: ");
            nombre = sc.nextLine();

        } while (!validarNombre(nombre));

        do {

            System.out.print("Introduce una descripcion: ");
            descripcion = sc.nextLine();

        } while (!validarDescripcion(descripcion));

        do {

            System.out.print("Introduce un DNI: ");
            dni = sc.nextLine();

        } while (!validarDni(dni));

        do {

            System.out.print("Introduce un codigo: ");
            codigo = sc.nextLine();

        } while (!validarCodigo(codigo));

        do {

            System.out.print("Introduce una fecha: ");
            fecha = sc.nextLine();

        } while (!validarFecha(fecha));

        System.out.println("Okay!");

    }

}

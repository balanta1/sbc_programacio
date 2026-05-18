package proyectofinal;

import java.util.ArrayList;

// Comentarios para recordatorio por un video que vi
//=========================================================================
class Estudiante {
    private String nombre;
    private int id;
    private double promedio;
    private int HoDeporte = 0, HoCultura = 0, HoSaludformaind = 0;
    private int Actividades = 0;

    public Estudiante(String nombre, double promedio, int id) {
        this.nombre = nombre;
        this.id = id;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getid() {
        return id;
    }

    public double getpromedio() {
        return promedio;
    }

    public int getHoDeporte() {
        return HoDeporte;
    }

    public int getHoCultura() {
        return HoCultura;
    }

    public int getHoSaludformaind() {
        return HoSaludformaind;
    }

    public void acumulaciondeHoras(String mismacategoria, int Ho) {
        
        if (mismacategoria.equalsIgnoreCase("Deporte"))
            HoDeporte += Ho;
        if (mismacategoria.equalsIgnoreCase("Cultura"))
            HoCultura += Ho;
        if (mismacategoria.equalsIgnoreCase("Salud"))
            HoSaludformaind += Ho;
    }

    public int getActividades() {
        return Actividades;
    }

    public void añadir() {
        this.Actividades++;
    }

    public void reiniciar() {
        this.Actividades = 0;
    }

    public int getTotalHo() {
        return HoDeporte + HoCultura + HoSaludformaind;
    }
}

class Actividades {
    private String nombre, categoria;
    private int horario, partMaximo;
    private boolean AltoImpacto;
    private int sumaCalificaciones = 0, TotalCalificaciones = 0;

    public Actividades(String nombre, String categoria, int horario, int partMaximo, boolean AltoImpacto) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.horario = horario;
        this.partMaximo = partMaximo;
        this.AltoImpacto = AltoImpacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getHorario() {
        return horario;
    }

    public int getpartMaximo() {
        return partMaximo;
    }

    public boolean isAltoImpacto() { // Mejor nombrado como isAltoImpacto
        return AltoImpacto;
    }

    public void promedionotas(int nota) {
        if (nota >= 1 && nota <= 5) {
            sumaCalificaciones += nota;
            TotalCalificaciones++;
        }
    }
}

class Inscripciones {
    private Estudiante estudiante;
    private Actividades actividades;
    // Eliminé el "id" de inscripción ya que no se usaba de manera práctica

    public Inscripciones(Estudiante estudiante, Actividades actividades) {
        this.estudiante = estudiante;
        this.actividades = actividades;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividades getActividades() {
        return actividades;
    }
}

// ========================================================================

class gestioncupos {
    private ArrayList<Inscripciones> inscripcion = new ArrayList<>();
    private ArrayList<Estudiante> listadeEspera = new ArrayList<>();

    public void inscripcionEstudiante(Estudiante estudiante, Actividades actividades) {
        System.out.println("\n-> Evaluando inscripcion de " + estudiante.getNombre() + " en " + actividades.getNombre());
        
        if (actividades.isAltoImpacto() && estudiante.getpromedio() < 4.0) {
            System.out.println("  Lo sentimos solicitud rechazada: Promedio insuficiente para estos eventos o viajes.");
            return;
        }
        
        for (Inscripciones inscripciones : inscripcion) {
            if (inscripciones.getEstudiante() == estudiante
                    && inscripciones.getActividades().getHorario() == actividades.getHorario()) {
                System.out.println("  Lo sentimos solicitud rechazada: Cruce de horarios con "
                        + inscripciones.getActividades().getNombre());
                return;
            }
        }
        
        long cuposllenos = inscripcion.stream().filter(i -> i.getActividades() == actividades).count();
        if (cuposllenos < actividades.getpartMaximo()) { // Corregido: getpartMaximo y actividades
            inscripcion.add(new Inscripciones(estudiante, actividades));
            System.out.println("  Solicitud aceptada: Inscrito exitosamente.");
        } else {
            listadeEspera.add(estudiante); // Corregido: estudiante
            System.out.println("  Atencion: cupos llenos. Se le agregará a Lista de Espera.");
        }
    }

    public void cancelarIncripsiones(Estudiante estudiante, Actividades actividades, boolean conAntelacion) {
        System.out.println("\n-> Cancelando inscripcion de " + estudiante.getNombre() + " en " + actividades.getNombre());
        Inscripciones encontrada = null;
        
        for (Inscripciones ins : inscripcion) {
            if (ins.getEstudiante() == estudiante && ins.getActividades() == actividades) {
                encontrada = ins;
                break;
            }
        }

        if (encontrada != null) {
            inscripcion.remove(encontrada);
            System.out.println("  Estudiante retirado.");

            if (!conAntelacion) {
                estudiante.acumulaciondeHoras("Deporte", -2);
                System.out.println("  AVISO: Penalizacion de -2 horas por cancelar su inscripcion con poco tiempo de antelacion.");
            }

            if (!listadeEspera.isEmpty()) {
                Estudiante siguiente = listadeEspera.remove(0);
                inscripcion.add(new Inscripciones(siguiente, actividades)); // Corregido: actividades
                System.out.println("  SISTEMA: " + siguiente.getNombre() + " cambio de la lista de espera al cupo cedido.");
            }
        }
    }

    public void completarActividad(Estudiante est, Actividades act, int horas) {
        est.acumulaciondeHoras(act.getCategoria(), horas);
        est.añadir();

        if (est.getActividades() == 3) {
            est.acumulaciondeHoras(act.getCategoria(), 5);
            System.out.println("\n¡BONO RENDIMIENTO!: " + est.getNombre()
                    + " Se le otorga 5 horas adicionales por completar ciclo de bienestar " + act.getCategoria());
            est.reiniciar();
        }
    }

    public void ReporteFinal(Estudiante est) {
        System.out.println("\n=======================================");
        System.out.println("  CERTIFICADO DE GRADO UNIAJC: " + est.getNombre().toUpperCase());
        System.out.println("=======================================");
        System.out.println("  Horas Deporte: " + est.getHoDeporte() + "/10");
        System.out.println("  Horas Cultura: " + est.getHoCultura() + "/10");
        System.out.println("  Horas Salud/Forma Ind: " + est.getHoSaludformaind() + "/10");
        System.out.println("  Total Acumulado: " + est.getTotalHo() + " horas.");

        if (est.getHoDeporte() >= 10 && est.getHoCultura() >= 10 && est.getHoSaludformaind() >= 10) {
            System.out.println("  Verificación académica: Cumple con los requisitos de grado ");
        } else {
            System.out.println("  Verificación académica: No habilitado para graduarse");
        }
        System.out.println("======================================="); 
    }
}

public class Final {
    public static void main(String[] args) {
        gestioncupos sistema = new gestioncupos();

        // Corregido: Se añadieron IDs al constructor
        Estudiante sebastian = new Estudiante("sebastian", 5.0, 101);
        Estudiante stiven = new Estudiante("stiven", 3.5, 102);
        Estudiante camila = new Estudiante("camila", 4.0, 103);

        Actividades futbol = new Actividades("Torneo Futbol", "Deporte", 7, 3, true);
        Actividades Baile = new Actividades("Evento Cultural", "Cultura", 6, 5, true);
        Actividades gym = new Actividades("Implementacion Salud", "Salud", 15, 10, false);

        sistema.inscripcionEstudiante(sebastian, futbol);
        sistema.inscripcionEstudiante(stiven, futbol);
        sistema.inscripcionEstudiante(camila, futbol);

        sistema.inscripcionEstudiante(sebastian, Baile);
        sistema.inscripcionEstudiante(camila, Baile);
        sistema.inscripcionEstudiante(stiven, Baile);

        sistema.cancelarIncripsiones(camila, futbol, false);

        sistema.completarActividad(sebastian, futbol, 15); 
        sistema.completarActividad(sebastian, futbol, 10);
        sistema.completarActividad(stiven, futbol, 10);

        sistema.completarActividad(sebastian, Baile, 15);
        sistema.completarActividad(camila, Baile, 11);
        sistema.completarActividad(sebastian, gym, 12);

        
        futbol.promedionotas(5);
        futbol.promedionotas(4);
        Baile.promedionotas(5);

        sistema.ReporteFinal(sebastian);
        sistema.ReporteFinal(stiven);
        sistema.ReporteFinal(camila);
    }
}
/**
 * Created by 46406163y on 23/01/17.
 */
public class Llibre {

    private int llibre_id;
    private String títol;
    private int nombre_exemplars;
    private String editorial;
    private int nombre_pagines;
    private int any_edicio;

    public Llibre() {}

    public Llibre(int llibre_id, String títol, int nombre_exemplars, String editorial, int nombre_pagines, int any_edicio) {
        this.llibre_id = llibre_id;
        this.títol = títol;
        this.nombre_exemplars = nombre_exemplars;
        this.editorial = editorial;
        this.nombre_pagines = nombre_pagines;
        this.any_edicio = any_edicio;
    }

    public int getLlibre_id() {
        return llibre_id;
    }

    public void setLlibre_id(int llibre_id) {
        this.llibre_id = llibre_id;
    }

    public String getTítol() {
        return títol;
    }

    public void setTítol(String títol) {
        this.títol = títol;
    }

    public int getNombre_exemplars() {
        return nombre_exemplars;
    }

    public void setNombre_exemplars(int nombre_exemplars) {
        this.nombre_exemplars = nombre_exemplars;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNombre_pagines() {
        return nombre_pagines;
    }

    public void setNombre_pagines(int nombre_pagines) {
        this.nombre_pagines = nombre_pagines;
    }

    public int getAny_edicio() {
        return any_edicio;
    }

    public void setAny_edicio(int any_edicio) {
        this.any_edicio = any_edicio;
    }
}

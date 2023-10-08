package com.example.recyclerview_lab1.repositorios;

import com.example.recyclerview_lab1.modelo.Trabajador;
import com.example.recyclerview_lab1.modelo.TrabajadorHora;
import com.example.recyclerview_lab1.modelo.TrabajadorTiempoCompleto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrabajadorRespositos {
    List<Trabajador> mainList;


    public TrabajadorRespositos(){
        mainList = new ArrayList<>();
        TrabajadorTiempoCompleto tc1 = new TrabajadorTiempoCompleto("1", "Roberto", "Canales", 750){};
        TrabajadorTiempoCompleto tc2 = new TrabajadorTiempoCompleto("2", "Francisco", "Zepeda", 850){};
        TrabajadorHora th1 = new TrabajadorHora("3", "Dania", "Garcia", 10, (float)5.25 ){};
        TrabajadorHora th2 = new TrabajadorHora("4", "Liseth", "Lara", 10, (float)5.25 ){};

        mainList.add(tc1);
        mainList.add(tc2);
        mainList.add(th1);
        mainList.add(th2);

    }

    public List<Trabajador> getAllListTrabajadores(){
        return this.mainList;
    }

    public Trabajador getTrabajadorById(String idMainObject){
        for (Trabajador person : mainList) {
            if (Objects.equals(person.getCodigoPersona(), idMainObject)) {
                return person;
            }
        }
        return null;
    }

    public boolean AddTrabajador(Trabajador mainObject) {
        return this.mainList.add(mainObject);
    }
    public boolean removeTrabajador(Trabajador trabajador) {
        return this.mainList.remove(trabajador);
    }

}

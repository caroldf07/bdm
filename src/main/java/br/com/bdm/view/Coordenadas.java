package br.com.bdm.view;

import com.opencsv.bean.CsvBindByPosition;

public class Coordenadas {
    @CsvBindByPosition(position = 0)
    private double latitude;
    @CsvBindByPosition(position = 1)
    private double longitude;

    @Override
    public String toString() {
        return latitude + "," + longitude;
    }
}

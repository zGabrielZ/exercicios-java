package br.com.gabrielferreira.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static br.com.gabrielferreira.validate.ValidarCampos.*;
import static br.com.gabrielferreira.utils.DataUtils.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaHotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;

    @Getter
    private final Integer numeroHotel;

    @Getter
    @Setter
    private LocalDate checkIn;

    @Getter
    @Setter
    private LocalDate checkOut;

    public ReservaHotel(UUID id, Integer numeroHotel, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.numeroHotel = numeroHotel;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        validarId(id);
        validarNumeroHotel(numeroHotel);
        validarCheckIn(checkIn);
        validarCheckOut(checkOut, checkIn);
    }

    public Integer getDuracaoDias(){
        if(this.checkIn != null && this.checkOut != null){
            long dias = ChronoUnit.DAYS.between(checkIn, checkOut);
            return (int) dias;
        }
        return null;
    }

    public void updateDatas(LocalDate checkIn, LocalDate checkOut){
        validarCheckIn(checkIn);
        validarCheckOut(checkOut, checkIn);
        validarReservaUpdate(checkIn, checkOut);

        this.setCheckIn(checkIn);
        this.setCheckOut(checkOut);
    }

    @Override
    public String toString() {
        return String.format("Reserva : Quarto %s, check-in : %s, check-out : %s, %s dias", this.numeroHotel, toDataBrasil(this.checkIn), toDataBrasil(this.checkOut), getDuracaoDias());
    }
}

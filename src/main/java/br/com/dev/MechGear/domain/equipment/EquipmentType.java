package br.com.dev.MechGear.domain.equipment;

import br.com.dev.MechGear.infra.exception.ValidateException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum EquipmentType {
    APARADOR("Aparador"),
    BOMBA_SUBMERSA("Bomba Submersa"),
    COMPRESSOR("Compressor"),
    CORTADOR_DE_GRAMA("Cortador de Grama"),
    GERADOR("Gerador"),
    LAVA_JATO("Lava Jato"),
    MOTOR_ESTACIONÁRIO("Motor Estacionário"),
    MOTOBOMBA("Motobomba"),
    MOTOCULTIVADOR("Motocultivador"),
    MOTOSSERRA("Motosserra"),
    ROÇADEIRA("Roçadeira"),
    SOPRADOR("Soprador");

    private final String descricao;

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static EquipmentType fromValue(String value) {
        for (EquipmentType type : EquipmentType.values()) {
            if (type.getDescricao().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new ValidateException("Valor inválido para tipo de equipamento: " + value, HttpStatus.BAD_REQUEST);
    }
}
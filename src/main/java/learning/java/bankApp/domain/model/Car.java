package learning.java.bankApp.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record Car(
        @NotBlank (message = "'manufacturer' could not be 'null' or 'empty'")
        String manufacturer,

        @NotNull(message = "'license plate' could not be null.")
        @Size(min=2, max=14, message="license plate length should be in range [2,14]")
        String licensePlate,

        @Min(value=2, message="'seat count' should be at least two.")
        int seatCount)
{
    //nothing for while
}

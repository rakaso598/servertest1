package com.kh.product.web.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateForm {
        @NotBlank(message = "필수 입력 필드입니다.")
        private String pname;
        @NotNull(message = "필수 입력 필드입니다.")
        private Long quantity;
        @NotNull(message = "필수 입력 필드입니다.")
        @Min(value = 1000, message = "값은 최소 1000 이어야 합니다.")
        private Long price;
}

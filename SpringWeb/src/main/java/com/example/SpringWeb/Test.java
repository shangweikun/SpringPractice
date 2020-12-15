package com.example.SpringWeb;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Test implements Serializable {
	@Getter@Setter String test;
}

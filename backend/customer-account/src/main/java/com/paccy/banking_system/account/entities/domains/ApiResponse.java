package com.paccy.banking_system.account.entities.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ApiResponse <T> {

  private final String timeStamp = LocalDateTime.now().toString();
  private  T data;
  private String message;
  private HttpStatus status;

    public ApiResponse(T data, String message, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public ResponseEntity<ApiResponse<T>> toResponseEntity(){
        assert this.status != null;
        return ResponseEntity.status(this.status).body(this);
    }
}

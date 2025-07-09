package br.com.desafio.creditoapi.adapters.in.web;

import br.com.desafio.creditoapi.adapters.in.web.dto.CreditoResponseDTO;
import br.com.desafio.creditoapi.application.CreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/creditos")
@CrossOrigin(origins = "*")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoResponseDTO>> getCreditosByNfse(@PathVariable String numeroNfse) {
        List<CreditoResponseDTO> response = creditoService.findByNumeroNfse(numeroNfse)
                .stream()
                .map(CreditoResponseDTO::fromDomain)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoResponseDTO> getCreditoByNumero(@PathVariable String numeroCredito) {
        CreditoResponseDTO response = CreditoResponseDTO.fromDomain(creditoService.findByNumeroCredito(numeroCredito));
        return ResponseEntity.ok(response);
    }
}

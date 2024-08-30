package com.squad1.locadora.entities.aluguel;

import com.squad1.locadora.entities.carro.Carro;
import com.squad1.locadora.entities.pessoa.Motorista;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alugueis")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private float valorTotal;

    @OneToOne
    @JoinColumn(name = "apolice_id")
    private ApoliceSeguro apolice;
    
    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;
    
    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

}

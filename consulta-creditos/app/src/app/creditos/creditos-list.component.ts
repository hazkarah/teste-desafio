import {Component, OnInit} from '@angular/core';
import {CreditosService} from './creditos.service';
import {Credito} from '../shared/models/credito';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-creditos-list',
  templateUrl: './creditos-list.component.html',
  styleUrls: ['./creditos-list.component.scss'],
  standalone: false
})
export class CreditosListComponent implements OnInit {
  form: FormGroup;
  credito: Credito | null = null;
  creditoList: Credito[] = [];
  carregando = false;
  erro = '';
  tipoConsulta: any;
  valorConsulta: any;
  displayedColumns: string[] = [
    'numeroCredito',
    'numeroNfse',
    'dataConstituicao',
    'valorIssqn',
    'tipoCredito',
    'simplesNacional',
    'aliquota',
    'valorFaturado',
    'valorDeducao',
    'baseCalculo'
  ];

  constructor(
    private creditosService: CreditosService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.form = this.fb.group({
      tipoConsulta: ['nfse'],
      valorConsulta: ['']
    });
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const numeroCredito = params.get('numeroCredito');
      if (numeroCredito) {
        this.form.patchValue({tipoConsulta: 'credito', valorConsulta: numeroCredito});
        this.buscar();
      }
    });
  }

  buscar() {
    this.carregando = true;
    this.erro = '';
    this.credito = null;
    this.creditoList = [];
    const tipoConsulta = this.form.value.tipoConsulta;
    const valorConsulta = this.form.value.valorConsulta;
    if (tipoConsulta === 'nfse') {
      this.creditosService.listarPorNfse(valorConsulta).subscribe({
        next: (res) => {
          this.creditoList = res;
          this.carregando = false;
          if (this.creditoList.length === 0) {
            this.erro = 'Nenhum crédito encontrado.';
          }
        },
        error: (err) => {
          this.erro = 'Erro ao buscar crédito.';
          this.carregando = false;
        }
      });
    } else {
      this.creditosService.buscarPorNumeroCredito(valorConsulta).subscribe({
        next: (res) => {
          this.credito = res;
          this.carregando = false;
          if (!this.credito) {
            this.erro = 'Nenhum crédito encontrado.';
          }
        },
        error: (err) => {
          this.erro = 'Erro ao buscar crédito.';
          this.carregando = false;
        }
      });
    }
  }
}

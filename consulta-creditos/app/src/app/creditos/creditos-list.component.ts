import { Component } from '@angular/core';
import { CreditosService } from './creditos.service';
import { Credito } from '../shared/models/credito';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-creditos-list',
  templateUrl: './creditos-list.component.html',
  styleUrls: ['./creditos-list.component.scss']
})
export class CreditosListComponent {
  form: FormGroup;
  credito: Credito | null = null;
  creditoList: Credito[] = [];
  carregando = false;
  erro = '';
  tipoConsulta: any;
  valorConsulta: any;

  constructor(private creditosService: CreditosService, private fb: FormBuilder) {
    this.form = this.fb.group({
      tipoConsulta: ['nfse'],
      valorConsulta: ['']
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
        },
        error: (err) => {
          this.erro = 'Erro ao buscar crédito.';
          this.carregando = false;
        }
      });
    }
  }
}

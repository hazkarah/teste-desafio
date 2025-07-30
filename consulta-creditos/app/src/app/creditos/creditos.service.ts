import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Credito} from '../shared/models/credito';
import {AuthService} from '../core/auth.service';

@Injectable({providedIn: 'root'})
export class CreditosService {
  constructor(private http: HttpClient, private auth: AuthService) {
  }

  listarPorNfse(numeroNfse: string): Observable<Credito[]> {
    const headers = new HttpHeaders({
      Authorization: this.auth.getBasicAuthHeader()
    });
    return this.http.get<Credito[]>(`/api/creditos/${numeroNfse}`, {headers});
  }

  buscarPorNumeroCredito(numeroCredito: string): Observable<Credito> {
    const headers = new HttpHeaders({
      Authorization: this.auth.getBasicAuthHeader()
    });
    return this.http.get<Credito>(`/api/creditos/credito/${numeroCredito}`, {headers});
  }
}



import {Injectable} from '@angular/core';

/**
 * Serviço de autenticação basico
 */
@Injectable({providedIn: 'root'})
export class AuthService {

  private username = 'guest';
  private password = 'guest';

  getBasicAuthHeader(): string {
    const token = btoa(`${this.username}:${this.password}`);
    return `Basic ${token}`;
  }
}


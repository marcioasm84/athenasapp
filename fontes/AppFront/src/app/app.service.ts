import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppModel } from './app-model';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  getHeader() {
    return new HttpHeaders({
      'Access-Control-Allow-Origin': '*'
    });
  }

  getPessoas(id: string) {
    let localUrl = "http://localhost:8080/pessoa";
    console.log('id', id);
    if(id != "") {
      localUrl += "/" + id;
    }
    return this.http.get<AppModel[]>(localUrl);
  }

  insertPessoa(pessoa: any) {
    let localUrl = "http://localhost:8080/pessoa";
    
    return this.http.post(localUrl, pessoa, { responseType: 'text'});
  }

  updatePessoa(id: number, pessoa: any) {
    let localUrl = "http://localhost:8080/pessoa/" + id;
    
    return this.http.put(localUrl, pessoa, { responseType: 'text'});
  }

  deletePessoa(id: number) {
    let localUrl = "http://localhost:8080/pessoa/" + id;
    
    return this.http.delete(localUrl, { responseType: 'text'});
  }

  getPesoIdeal(id: number) {
    let localUrl = "http://localhost:8080/pessoa/"+ id + "/pesoideal";
    return this.http.get(localUrl, { responseType: 'text'});
  }
}

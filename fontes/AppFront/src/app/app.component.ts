import { Component, OnInit } from '@angular/core';

import { AppService } from './app.service';
import { AppModel } from './app-model';

import { FormGroup, FormControl, Validators } from '@angular/forms';

import { formatNumber } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'AppFront';
  lista: AppModel[] = [];
  loading = false;
  showModal = false;

  id = new FormControl('');
  nome = new FormControl('', [Validators.required]);
  sexo= new FormControl('');
  dataNascimento = new FormControl('', [Validators.required]);
  cpf = new FormControl('', [Validators.required]);
  altura = new FormControl('', [Validators.required]);
  peso = new FormControl('', [Validators.required]);
  
  idPessoaEditar: number = -1;

  constructor(private service: AppService){
    this.obterPessoas();
  }

  ngOnInit(): void {
  }

  obterPessoas() {
    this.loading = true;
    this.service.getPessoas(this.id.value).subscribe({
      error: (error) => { 
        this.lista = [];
        this.loading = false;
      },
      next: (data) => { 
        this.lista = data.map( (item) => {
          //item.dataNascimento = item.dataNascimento.split('-').reverse().join('/');
          //item.peso = formatNumber( Number(item.peso), 'ptBr');
          //item.altura = item.altura.replace(',', '').replace('.', ',');
          return item;
        }); 
      },
      complete: () => {
        this.loading = false;
      }
    });
  }

  novaPessoa() {
    this.idPessoaEditar = -1;
    this.nome.setValue("");
    this.sexo.setValue("");
    this.dataNascimento.setValue("");
    this.cpf.setValue("");
    this.altura.setValue("");
    this.peso.setValue("");
}

  editarPessoas(pessoa: any) {
      this.idPessoaEditar = pessoa.id;
      this.nome.setValue(pessoa.nome);
      this.sexo.setValue(pessoa.sexo);
      this.dataNascimento.setValue(pessoa.dataNascimento);
      this.cpf.setValue(pessoa.cpf);
      this.altura.setValue(pessoa.altura);
      this.peso.setValue(pessoa.peso);
  }

  salvarPessoas() {
    if(this.nome.invalid ||
      this.dataNascimento.invalid ||
      this.cpf.invalid ||
      this.altura.invalid ||
      this.peso.invalid) {
        alert("Preencha todos os campos!");
        return;
    }

    let pessoa = {
      nome: this.nome.value,
      sexo: this.sexo.value,
      dataNascimento: this.dataNascimento.value,
      cpf: this.cpf.value,
      altura: this.altura.value,
      peso: this.peso.value
    };
    console.log('pessoa', pessoa);

    this.loading = true;

    //Inserção
    if(this.idPessoaEditar == -1) {
      this.service.insertPessoa(pessoa).subscribe({
        error: (error) => { 
          this.loading = false;
          console.log('Erro', error);
          alert("Erro ao inserir o registro");
        },
        next: () => {
          this.loading = false;
          alert("Salvo com sucesso!");
          this.obterPessoas();
        }
      });
    } else {
      this.service.updatePessoa(this.idPessoaEditar, pessoa).subscribe({
        error: (error) => { 
          this.loading = false;
          console.log('Erro', error);
          alert("Erro ao atualizar o registro");
        },
        next: () => {
          this.loading = false;
          alert("Atualizado com sucesso!");
          this.obterPessoas();
        }
      });
    }
  }

  excluirPessoa(id: number) {
    if(!confirm('Deseja realmente excluir esse registro?')) return;
    this.loading = true;
    this.service.deletePessoa(id).subscribe({
      error: (error) => { 
        this.loading = false;
        console.log('Erro', error);
        alert("Erro ao excluir o registro");
      },
      next: () => {
        this.loading = false;
        alert("Excluido com sucesso!");
        this.obterPessoas();
      }
    });
  }


  obterPesoIdeal(id: number) {
    this.loading = true;
    this.service.getPesoIdeal(id).subscribe({
      error: (error) => { 
        this.loading = false;
        console.log('Erro', error);
        alert("Erro ao obter o peso ideal");
      },
      next: (data) => {
        this.loading = false;
        alert("O Peso ideal é: "+formatNumber(Number(data), 'pt-BR', '1.0-2'));
      }
    });
  }

}

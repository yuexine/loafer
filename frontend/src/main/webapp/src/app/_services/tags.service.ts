import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions} from "@angular/http";

@Injectable()
export class TagService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});

  constructor(private http: Http) {

  }


  postTag() {

  }

  getTagsByPage() {
    let url = '';
    let params = {};

    this.http.get(url, JSON.stringify(params));
  }

  updateTag() {

  }

  deleteTag() {

  }
}

import {Injectable} from "@angular/core";
import {Response, URLSearchParams} from "@angular/http";
import {HttpService} from "./http.service";
import "rxjs/add/operator/map";
import {Post} from "../models/Post";

@Injectable()
export class PostService {

  constructor(private http: HttpService) {

  }

  getPost(id: number) {
    return this.http.get(`api/post/${id}`).map((response: Response) => response.json());
  }

  createPost(post: Post) {
    return this.http.post(`/`, post).map((response: Response) => response.json());
  }

  updatePost(post: Post) {

  }

  getPostSummaries(type: string, topic: string, page: number, size: number) {
    let params = new URLSearchParams();
    params.set('topic', topic);
    params.set('page', page.toString());
    params.set('size', size.toString());
    console.log(params)
    return this.http.get(`api/post/summary/${type}`, {params: params}).map((response: Response) => response.json());
  }
}

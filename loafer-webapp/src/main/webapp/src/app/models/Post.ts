import {Tag} from "./Tag";

export class Post {
  private _id: number;
  private _author: string;
  private _title: string;
  private _summary: string;
  private _content: string;
  // https://stackoverflow.com/questions/12870291/typescript-typed-array-usage
  private _tags: Tag[];


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get author(): string {
    return this._author;
  }

  set author(value: string) {
    this._author = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get summary(): string {
    return this._summary;
  }

  set summary(value: string) {
    this._summary = value;
  }

  get content(): string {
    return this._content;
  }

  set content(value: string) {
    this._content = value;
  }

  get tags(): Tag[] {
    return this._tags;
  }

  set tags(value: Tag[]) {
    this._tags = value;
  }
}

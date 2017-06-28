export class Topic {
  private id: number;
  private name: string;
  private description: string;
  private image: string;

  constructor(id: number, name: string, description: string, image: string) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.image = image;
  }
}

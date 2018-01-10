export default class UserEditorService {
  constructor(startUrl) {
    this.startUrl = startUrl;
  }

  create(userProfile) {
    return fetch(this.startUrl + "userProfile", {
      method: "post",
      headers: new Headers({
        "Content-type": "application/json;chartSet=UTF-8",
        "token": localStorage.getItem("token")
      }),
      body: JSON.stringify(userProfile)
    });
  }

  get(id) {
    return fetch(this.startUrl + "userProfile/" + id, {
      method: "get",
      headers: new Headers({
        "Content-type": "application/json;chartSet=UTF-8",
        "token": localStorage.getItem("token")
      })
    });
  }

  update(userProfile) {
    return fetch(this.startUrl + "userProfile", {
      method: "put",
      headers: new Headers({
        "Content-type": "application/json;chartSet=UTF-8",
        "token": localStorage.getItem("token")
      }),
      body: JSON.stringify(userProfile)
    });
  }
}

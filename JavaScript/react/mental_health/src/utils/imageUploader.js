import blobUtil from 'blob-util';

export default class ImageUploader {

  async imageUpload (event, image) {

    let sleep = (ms) => {
      return new Promise(resolve => setTimeout(resolve, ms));
    }
    
    let selectedImage = event.target.files[0];
    let reader = new FileReader();
    let globalBase64String = "start value";

    reader.onload = (event) => {

      blobUtil.imgSrcToBlob(event.target.result, 'image/jpeg').then((blob) => {
        let blobURL = blobUtil.createObjectURL(blob);
        image.src = blobURL;

        blobUtil.blobToBase64String(blob).then((base64String) => {
          globalBase64String = base64String;

        }).catch((err) => {
          alert("Error occurred with binaryString: " + err);
        });

      }).catch((err) => {
        alert("Error occurred with blob: " + err);
      });
    }
    reader.readAsDataURL(selectedImage);
    await sleep(250);
    return globalBase64String;
  }
}

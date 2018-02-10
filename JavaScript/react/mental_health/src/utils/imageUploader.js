import blobUtil from 'blob-util';

export default class ImageUploader {

  async imageUpload (event, image) {

    let sleep = (ms) => {
      return new Promise(resolve => setTimeout(resolve, ms));
    }

    let selectedImage = event.target.files[0];
    let reader = new FileReader();
    let returnableValue;

    reader.onload = (event) => {
      blobUtil.imgSrcToBlob(event.target.result, 'image/jpeg').then((blob) => {
        image.src = blobUtil.createObjectURL(blob);

        blobUtil.blobToBase64String(blob).then((base64String) => {
          returnableValue = base64String;
        }).catch((err) => {
          alert("Error occurred with binaryString: " + err);
        });

      }).catch((err) => {
        alert("Error occurred with blob: " + err);
      });
    }
    reader.readAsDataURL(selectedImage);
    await sleep(1000);
    return returnableValue;
  }

  imageMount = (base64String, image) => {
    blobUtil.base64StringToBlob(base64String, 'image/jpeg').then(function (blob) {
      blobUtil.blobToDataURL(blob).then(function (dataURL) {
        image.src = dataURL;
      }).catch(function (err) {
        alert("Error occurred with DataURL: " + err);
      });
    }).catch(function (err) {
      alert("Error occurred with blob: " + err);
    });
  }
}

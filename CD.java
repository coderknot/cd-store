public class CD{
  public String mArtistName;
  public String mAlbumName;
  public int mReleaseYear;
  public int mPrice;

  public CD (String artistName, String albumName, int releaseYear, int price){
    mArtistName = artistName;
    mAlbumName = albumName;
    mReleaseYear = releaseYear;
    mPrice = price;
  }

  public CD (CD cdObject){
    this.mArtistName = cdObject.mArtistName;
    this.mAlbumName = cdObject.mAlbumName;
    this.mReleaseYear = cdObject.mReleaseYear;
    this.mPrice = cdObject.mPrice;
  }

}

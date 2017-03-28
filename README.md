# SnpDownloadService
For Kate@Athletigen

## Built with
* Hibernate
* AWS s3 storage

## What does it do
Download a file from MySQL DB by its primary key, retrieve a AWS S3 path from the query and download a file according to the S3 path

## Usage
* Download the folder to local drive
```
git clone https://github.com/yeliangdal/SnpDownloadService.git
```
* Import the project to your IDE (e.g. Eclipse) 
* Change SQL configuration in src/main/resources/hibernate.cfg.xml
* Change AWS s3 credentials in /src/com/snpData/s3Access/AWSS3DownloadUtil.java
* Compile and run


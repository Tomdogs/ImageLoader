# ImageLoader

* #Android Bitmap的高速加载  
* 如何避免过多的流量消耗，可用“缓存”技术 <br> 
所谓缓存：当程序第一次从网络加载图片后，就将加载其缓存到存储设备上，这样下次使用图片就不用再从网络上获取。为了提高应用的用户体验，往往还会把图片在内存中缓存一份，在设备上也会缓存一份。当用户打算从网络中请求一张图片时，程序首先从内存中索取，若没有到设备中索取,若设备上也没有，才到网络上下载图片。

* #所用技术  
 * 目前程序中的一种缓存算法是LRU（Least Rencently Used），LRU是最近最少使用算法，它的核心思想是当缓存满时，会优先淘汰那些最近最少使用的缓存对象。采用LRU算法的缓存有两种：LruCache和DiskLruCache，lruCache实现内存缓存，而DiskLruCache则充当了存储设备缓存,通过这二者的完美结合,就可以实现一个具有很高实用价值的imageloader。  <br>
（实例参考  任玉刚  Android开发艺术探索）

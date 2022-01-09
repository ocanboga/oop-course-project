# Nesneye Dayalı Programlamanın Temel Yapıları, Tasarım Desenleri ve JUnit Kullanımı
1. Proje Hazırlığı  
   Projede bizden bir probleme tasarım desenleri yardımıyla çözüm bulunması ve bunun ardından da Netbeans ortamı üzerinde Java programlama dili ile kodlanması isteniyor. Problemimizi incelediğimizde görüyoruz ki birden fazla bilgiler barındıran (maaş, isim, pozisyon, yönetici bilgisi gibi) kişilerin hiyerarşik olarak tutulması ve bunların istenildiğinde topluca veya teker teker yazdırılması gerekiyor (maaşları, maaşların toplamı ve bilgileriyle beraber). Bunun için de öncelikle uygun bir tasarım deseni seçmemiz gerekiyor bunun için de araştırmalarımıza göre en uygun tasarım desenini genel şeması aşağıdaki şekilde gözüktüğü gibi olan “Composite Pattern” olarak belirledik.
 
Composite Design UML Örneği   
   Bu oluşturduğumuz hiyerarşik yapının da ArrayList kullanılmadan kendi oluşturduğumuz Iterator ile dolaşılması gerekiyor. Bunun için de projede de verildiği gibi “Iterator Pattern” kullandık.   
 
   Bu veriler okunurken de belirli bir düzende okunacak. Bize verilen örnekte biz bir metin dosyasından (.txt uzantılı bir dosyadan) okuma yapıyoruz bu dosyadan okumanın yanı sıra bizden farklı dosya tiplerinden ve/veya databaselerden de okuma yapılabilmesini istiyor bunun içinde kullanılabilecek en uygun tasarım desenini de “Strategy Pattern” olarak belirledik.   

2. Uygun Tasarım Desenlerinin Belirlenmesi ve Açıklanması   
   Proje hazırlık aşamasını ve araştırmalarımızı tamamlamamızın ardından belirlediğimiz tasarım desenlerini Netbeans ortamında Java kodu ile gerçekleştirdik.     
2.1 “Composite Pattern” Tasarım Deseni   
“Composite Pattern”e uygun olarak bizim projemizde yer alan Memur ve Direktor sınıflarını “leaf” olarak belirledik. Belirlediğimiz bu “leaf”ler “Composite” adında bir “leaf”te işlem görüp bunların hepsi de “Calisan” sınıfı altında birleşiyor. Bu şekilde girilen her bir memur ve direktör “Calisan” sınıfı ile erişilebilir ve kullanılabilir bir hale geliyor. Ayrıca bu şekilde çalışanlar memur ve direktör olarak ayrılmış oluyor. Atadığımız bu verileri “Composite” sınıfı ile işleyip projede istediğimiz şekilde işliyoruz. UML diyagramı da aşağıda gözüktüğü gibidir.   
   

 ![Composite Pattern UML](https://user-images.githubusercontent.com/53763911/148693211-221250ab-76f1-47da-9fcc-ebb4efcb7978.png)   
                       Composite Pattern Dizaynımızın UML Diyagramı   

2.2 “Iterator Pattern” Tasarım Deseni   
   ArrayList kullanmadan girdiğimiz çalışan verileri arasında dönebilmek için projede de verilen “Iterator Pattern”i kullandık. Bu tasarım desenini kullanırken de iterator ile döneceğimiz kendi listemizi tanımladık bunlar için gerekli arayüzleri yazdık ve hepsini asıl dönülecek verileri tutan “Calisan” sınıfına bağladık. UML diyagramı da aşağıda gözüktüğü gibidir.    
      
 ![Iterator Pattern UML](https://user-images.githubusercontent.com/53763911/148693245-654e4947-7f25-40a1-8a1e-b49a8d052b6a.png)   

Iterator Pattern Dizaynımızın UML Diyagramı   
2.3 “Strategy Pattern” Tasarım Deseni   

   Projede bizden test için okuduğumuz “girdi.txt” dosya tipi dışında farklı dosya tipi ile de işlem yapılabilmesini istiyor. Bunun için belirlediğimiz “Strategy Pattern”i kullandık. Bunu kullanırken örnek olarak da kendi kullandığımız tip olan “.txt” uzantılı dosyalara erişim sağlayan sınıfı yazdık. Bu desende “Register” ile dosya uzantıları tiplerine göre tutulup istenildiğinde o dosya uzantısını programımız destekliyorsa oradan bulup çalıştırmasını sağlıyor. UML diyagramı da aşağıda gözüktüğü gibidir.   
   
 ![Strategy Pattern UML](https://user-images.githubusercontent.com/53763911/148693261-715deee5-5d79-46ed-b55c-da76e5084ac4.png)   
Strategy Pattern Dizaynımızın UML Diyagramı   
2.4 Tüm Dizaynın UML Diyagramı   
 ![Tüm UML](https://user-images.githubusercontent.com/53763911/148693272-d80b3465-f3ab-4392-b280-19c3a153799b.png)   

Tüm Tasarımın UML Diyagramı   

3. Kullanılan Sınıfların Açıklanması   
3.1 Calisan Arayüzü   
   Calisan arayüzümüz tüm dizaynın temelini oluşturuyor. Memur, Direktor ve Composite sınıflarının yanı sıra List ve Iterator’de buraya bağlanıyor. Calisan arayüzü tüm sınıfların birbirleri ile doğru bir şekilde etkileşimi ve doğru bir şekilde erişimi sağlıyor. Composite Pattern yapısındaki “Leaf”leri tutan yer de burası oluyor.   
3.2 CalisanIterator Sınıfı   
   Kendi oluşturduğumuz “List”yi dönebilmek için gerekli olan iteratoru bu sınıf oluşturuyor. Iterator arayüzünden besleniyor ve liste içerisinde dönmemizi (dolaşmamızı) sağlayacak metodlara sahip bir şekilde listeyle beraber çalışıyor.   
3.3 CalisanList Sınıfı   
   Iterator ile birlikte çalışan bu sınıf bir List arayüzünden besleniyor. Bizim çalışanlarımızı tutmaya ve gerektiğinde dolaşmaya yardımcı oluyor.   
3.4 Composite Sınıfı    
   Composite sınıfımız Memur ve Direktor ile Calisan sınıfının bir “Leaf”i olarak bulunuyor ve Memur ve Direktor tipinde olan çalışanların işlenmesine (yazdırılmasına ve döndürülmesine) yardımcı oluyor.   
3.5 Direktor Sınıfı   
   Direktör tipinde bulunan personelleri bilgileriyle birlikte tutan ve bunları ilgili metotları ile döndürebilen bu sınıfımız Calisan sınıfının bir “Leaf”i olarak bulunuyor ve Memur ile benzer bir yapıya sahip oluyor.   
3.6 Memur Sınıfı   
   Memur tipinde bulunan personelleri bilgileriyle birlikte tutan ve bunları ilgili metotları ile döndürebilen bu sınıfımız Calisan sınıfının bir “Leaf”i olarak bulunuyor ve Direktor ile benzer bir yapıya sahip oluyor.   
3.7 Deneme Sınıfı   
   Deneme sınıfımız “main” metodun bulunduğu sınıf olarak yer alıyor. Burada tüm sınıflarımızın işlemleri gerçekleşiyor. Memur ve direktör atamalarının yanı sıra bunları atayacak dosyanın açılması ve doğru bir şekilde işlenmesi de bu sınıfta gerçekleşiyor. Aynı zamanda atadığı bu bilgileri dosyada arayıp istenilen çıktıları da bu sınıf veriyor.
3.8 FileReader Arayüzü   
   Bu sınıfımız Registry ve dosya okuyucularımız olan ExcelReader,TXTReader,XMLReader sınıflarımız ile ortak bir şekilde çalışıyor ve onların dosya okumasını sağlıyor.   
3.9 ExcelReader Sınıfı   
   Excel dosya tipi olan “.xls” tipi olan dosyaların okunmasında veya yazdırılmasında gerekli işlemleri gerçekleştirebilen sınıfımız.   
3.10 TXTReader Sınıfı   
   Yazı dosyası tipi olan “.txt” tipi olan dosyaların okunmasında veya yazdırılmasında gerekli işlemleri gerçekleştirebilen sınıfımız.   
3.11 XMLReader Sınıfı   
   “.xml” tipi olan dosyaların okunmasında veya yazdırılmasında gerekli işlemleri gerçekleştirebilen sınıfımız.   
3.12 Iterator Arayüzü   
   CalisanIterator tipini oluşturabilmemiz için gerekli metotları içeren arayüz.   
3.13 List Arayüzü   
   CalisanList tipini oluşturabilmemiz için gerekli liste metotlarını içeren arayüzümüz.   
3.14 Registry Sınıfı   
   Kaydettiğimiz dosya tipleri arasında istediğimiz dosya tipini seçebilen ve bunların gerekli işlemlerini sağlayan sınıfımız.   
4. Birim Testin Açıklanması   
   Örnek bir birim test oluşturmak için sınıflarımızı gezdik ve “main” metodunun da bulunduğu Deneme sınıfı üzerinde bir JUnit testi yazmaya karar kıldık. Testimizin dosyasını oluşturduktan sonra (DenemeTest.java) test edebileceğimiz verilere baktık ve burada bize mantıklı gelen kullanıcı girdisi verisini test etme kararı aldık. Testi yaparken kod üzerinde de görülebileceği gibi JUnit ile bir kullanıcı girdisi girdik bu kullanıcı girdisi bizim dosyadan okuduğumuz girdilerden birisi ile uyuşmazsa JUnit hata veriyor uyuşursa ise testi geçmiş sayılıyoruz. Bu şekilde testimizi yazdık ve testi geçer halde projemize ekledik.   


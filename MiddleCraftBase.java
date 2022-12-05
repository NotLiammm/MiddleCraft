/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.lang.management.RuntimeMXBean;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class b {
/*  21 */   private static final Logger a = LogManager.getLogger();
/*     */   
/*     */   private final String b;
/*     */   
/*     */   private final Throwable c;
/*     */   
/*  24 */   private final c d = new c(this, "System Details");
/*     */   
/*  25 */   private final List<c> e = Lists.newArrayList();
/*     */   
/*     */   private File f;
/*     */   
/*     */   private boolean g = true;
/*     */   
/*  28 */   private StackTraceElement[] h = new StackTraceElement[0];
/*     */   
/*     */   public b(String ☃, Throwable throwable) {
/*  31 */     this.b = ☃;
/*  32 */     this.c = throwable;
/*  34 */     h();
/*     */   }
/*     */   
/*     */   private void h() {
/*  38 */     this.d.a("Minecraft Version", new d<String>(this) {
/*     */           public String a() {
/*  41 */             return "1.9.4";
/*     */           }
/*     */         });
/*  45 */     this.d.a("Operating System", new d<String>(this) {
/*     */           public String a() {
/*  48 */             return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
/*     */           }
/*     */         });
/*  52 */     this.d.a("Java Version", new d<String>(this) {
/*     */           public String a() {
/*  55 */             return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
/*     */           }
/*     */         });
/*  59 */     this.d.a("Java VM Version", new d<String>(this) {
/*     */           public String a() {
/*  62 */             return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
/*     */           }
/*     */         });
/*  66 */     this.d.a("Memory", new d<String>(this) {
/*     */           public String a() {
/*  69 */             Runtime ☃ = Runtime.getRuntime();
/*  70 */             long l1 = ☃.maxMemory();
/*  71 */             long l2 = ☃.totalMemory();
/*  72 */             long l3 = ☃.freeMemory();
/*  73 */             long l4 = l1 / 1024L / 1024L;
/*  74 */             long l5 = l2 / 1024L / 1024L;
/*  75 */             long l6 = l3 / 1024L / 1024L;
/*  77 */             return l3 + " bytes (" + l6 + " MB) / " + l2 + " bytes (" + l5 + " MB) up to " + l1 + " bytes (" + l4 + " MB)";
/*     */           }
/*     */         });
/*  81 */     this.d.a("JVM Flags", new d<String>(this) {
/*     */           public String a() {
/*  84 */             RuntimeMXBean ☃ = ManagementFactory.getRuntimeMXBean();
/*  85 */             List<String> list = ☃.getInputArguments();
/*  86 */             int i = 0;
/*  87 */             StringBuilder stringBuilder = new StringBuilder();
/*  89 */             for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
/*  89 */               String str = iterator.next();
/*  90 */               if (str.startsWith("-X")) {
/*  91 */                 if (i++ > 0)
/*  92 */                   stringBuilder.append(" "); 
/*  95 */                 stringBuilder.append(str);
/*     */               } 
/*     */             } 
/*  99 */             return String.format("%d total; %s", new Object[] { Integer.valueOf(i), stringBuilder.toString() });
/*     */           }
/*     */         });
/* 103 */     this.d.a("IntCache", new d<String>(this) {
/*     */           public String a() throws Exception {
/* 106 */             return axt.b();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public String a() {
/* 112 */     return this.b;
/*     */   }
/*     */   
/*     */   public Throwable b() {
/* 116 */     return this.c;
/*     */   }
/*     */   
/*     */   public void a(StringBuilder ☃) {
/* 128 */     if ((this.h == null || this.h.length <= 0) && !this.e.isEmpty())
/* 129 */       this.h = (StackTraceElement[])ArrayUtils.subarray((Object[])((c)this.e.get(0)).a(), 0, 1); 
/* 132 */     if (this.h != null && this.h.length > 0) {
/* 133 */       ☃.append("-- Head --\n");
/* 134 */       ☃.append("Thread: ").append(Thread.currentThread().getName()).append("\n");
/* 135 */       ☃.append("Stacktrace:\n");
/*     */       StackTraceElement[] arrayOfStackTraceElement;
/*     */       int i, j;
/* 137 */       for (arrayOfStackTraceElement = this.h, i = arrayOfStackTraceElement.length, j = 0; j < i; ) {
/* 137 */         StackTraceElement stackTraceElement = arrayOfStackTraceElement[j];
/* 138 */         ☃.append("\t").append("at ").append(stackTraceElement.toString());
/* 139 */         ☃.append("\n");
/*     */         j++;
/*     */       } 
/* 141 */       ☃.append("\n");
/*     */     } 
/* 144 */     for (Iterator<c> iterator = this.e.iterator(); iterator.hasNext(); ) {
/* 144 */       c c1 = iterator.next();
/* 145 */       c1.a(☃);
/* 146 */       ☃.append("\n\n");
/*     */     } 
/* 149 */     this.d.a(☃);
/*     */   }
/*     */   
/*     */   public String d() {
/* 153 */     StringWriter ☃ = null;
/* 154 */     PrintWriter printWriter = null;
/* 155 */     Throwable throwable = this.c;
/* 157 */     if (throwable.getMessage() == null) {
/* 159 */       if (throwable instanceof NullPointerException) {
/* 160 */         throwable = new NullPointerException(this.b);
/* 161 */       } else if (throwable instanceof StackOverflowError) {
/* 162 */         throwable = new StackOverflowError(this.b);
/* 163 */       } else if (throwable instanceof OutOfMemoryError) {
/* 164 */         throwable = new OutOfMemoryError(this.b);
/*     */       } 
/* 167 */       throwable.setStackTrace(this.c.getStackTrace());
/*     */     } 
/* 170 */     String str = throwable.toString();
/*     */     try {
/* 173 */       ☃ = new StringWriter();
/* 174 */       printWriter = new PrintWriter(☃);
/* 175 */       throwable.printStackTrace(printWriter);
/* 176 */       str = ☃.toString();
/*     */     } finally {
/* 178 */       IOUtils.closeQuietly(☃);
/* 179 */       IOUtils.closeQuietly(printWriter);
/*     */     } 
/* 182 */     return str;
/*     */   }
/*     */   
/*     */   public String e() {
/* 186 */     StringBuilder ☃ = new StringBuilder();
/* 188 */     ☃.append("---- Minecraft Crash Report ----\n");
/* 189 */     ☃.append("// ");
/* 190 */     ☃.append(i());
/* 191 */     ☃.append("\n\n");
/* 193 */     ☃.append("Time: ");
/* 194 */     ☃.append((new SimpleDateFormat()).format(new Date()));
/* 195 */     ☃.append("\n");
/* 197 */     ☃.append("Description: ");
/* 198 */     ☃.append(this.b);
/* 199 */     ☃.append("\n\n");
/* 201 */     ☃.append(d());
/* 202 */     ☃.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");
/* 204 */     for (int i = 0; i < 87; i++)
/* 205 */       ☃.append("-"); 
/* 207 */     ☃.append("\n\n");
/* 208 */     a(☃);
/* 210 */     return ☃.toString();
/*     */   }
/*     */   
/*     */   public File f() {
/* 214 */     return this.f;
/*     */   }
/*     */   
/*     */   public boolean a(File ☃) {
/* 218 */     if (this.f != null)
/* 219 */       return false; 
/* 221 */     if (☃.getParentFile() != null)
/* 222 */       ☃.getParentFile().mkdirs(); 
/*     */     try {
/* 226 */       FileWriter fileWriter = new FileWriter(☃);
/* 227 */       fileWriter.write(e());
/* 228 */       fileWriter.close();
/* 230 */       this.f = ☃;
/* 231 */       return true;
/* 232 */     } catch (Throwable throwable) {
/* 233 */       a.error("Could not save crash report to " + ☃, throwable);
/* 234 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public c g() {
/* 239 */     return this.d;
/*     */   }
/*     */   
/*     */   public c a(String ☃) {
/* 243 */     return a(☃, 1);
/*     */   }
/*     */   
/*     */   public c a(String ☃, int i) {
/* 247 */     c c1 = new c(this, ☃);
/* 249 */     if (this.g) {
/* 250 */       int j = c1.a(i);
/* 251 */       StackTraceElement[] arrayOfStackTraceElement = this.c.getStackTrace();
/* 252 */       StackTraceElement stackTraceElement1 = null;
/* 253 */       StackTraceElement stackTraceElement2 = null;
/* 255 */       int k = arrayOfStackTraceElement.length - j;
/* 256 */       if (k < 0)
/* 257 */         System.out.println("Negative index in crash report handler (" + arrayOfStackTraceElement.length + "/" + j + ")"); 
/* 260 */       if (arrayOfStackTraceElement != null && 0 <= k && k < arrayOfStackTraceElement.length) {
/* 261 */         stackTraceElement1 = arrayOfStackTraceElement[k];
/* 263 */         if (arrayOfStackTraceElement.length + 1 - j < arrayOfStackTraceElement.length)
/* 264 */           stackTraceElement2 = arrayOfStackTraceElement[arrayOfStackTraceElement.length + 1 - j]; 
/*     */       } 
/* 268 */       this.g = c1.a(stackTraceElement1, stackTraceElement2);
/* 270 */       if (j > 0 && !this.e.isEmpty()) {
/* 271 */         c c2 = this.e.get(this.e.size() - 1);
/* 272 */         c2.b(j);
/* 273 */       } else if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length >= j && 0 <= k && k < arrayOfStackTraceElement.length) {
/* 274 */         this.h = new StackTraceElement[k];
/* 275 */         System.arraycopy(arrayOfStackTraceElement, 0, this.h, 0, this.h.length);
/*     */       } else {
/* 277 */         this.g = false;
/*     */       } 
/*     */     } 
/* 281 */     this.e.add(c1);
/* 282 */     return c1;
/*     */   }
/*     */   
/*     */   private static String i() {
/* 287 */     String[] ☃ = { 
/* 287 */         "Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", 
/* 287 */         "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", 
/* 287 */         "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", 
/* 287 */         "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };
/*     */     try {
/* 325 */       return ☃[(int)(System.nanoTime() % ☃.length)];
/* 326 */     } catch (Throwable throwable) {
/* 327 */       return "Witty comment unavailable :(";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static b a(Throwable ☃, String str) {
/*     */     b b1;
/* 334 */     if (☃ instanceof f) {
/* 335 */       b1 = ((f)☃).a();
/*     */     } else {
/* 337 */       b1 = new b(str, ☃);
/*     */     } 
/* 340 */     return b1;
/*     */   }
/*     */ }


/* Location:              C:\Users\yello\AppData\Roaming\.minecraft\versions\1.9.4\1.9.4.jar!\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
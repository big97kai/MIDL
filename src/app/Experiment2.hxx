#ifndef module_struct_h
#define module_struct_h

#ifndef rti_me_cpp_hxx
#include "rti_me_cpp.hxx"
#endif

#ifdef NDDS_USER_DLL_EXPORT
#if (defined(RTI_WIN32) || defined(RTI_WINCE))
/* If the code is building on Windows, start exporting symbols. */
#undef NDDSUSERDllExport
#define NDDSUSERDllExport __declspec(dllexport)
#endif
#else
#undef NDDSUSERDllExport
#define NDDSUSERDllExport
#endif

struct space_ASeq;
class space_ATypeSupport;
class space_ADataWriter;
class space_ADataReader;
class space_A
{
  public:
    typedef struct space_ASeq Seq;
    typedef space_ATypeSupport TypeSupport;
    typedef space_ADataWriter DataWriter;
    typedef space_ADataReader DataReader;

    CDR_Int16 i1 = 10;


    CDR_Int16 i2 = 10;


    CDR_Int32 i3 = 100;


    CDR_Int32 i4 = 100;


    CDR_Int64 i5 = 1000;


    CDR_Int64 i6 = 1000;


    CDR_Uint16 i7 = 10;


    CDR_Uint16 i8 = 10;


    CDR_Uint32 i9 = 100;


    CDR_Uint32 i10 = 100;


    CDR_Uint64 i11 = 1000;


    CDR_Uint64 i12 = 1000;


    CDR_Char c0 = 'a';


    CDR_String c1 = "abc";


    CDR_Boolean c2 = true;


    CDR_Float c3 = 10.901f;


    CDR_Double c4 = 23.234d;


    CDR_LongDouble c5 = 12.23456432235d;


    CDR_Int16 arr[10] = [0,1,2,3,4,5,6,7,8,9];

};

extern const char *space_ATYPENAME;

REDA_DEFINE_SEQUENCE_STRUCT(space_ASeq, space_A);

REDA_DEFINE_SEQUENCE_IN_C(space_ASeq,space_A);

NDDSUSERDllExport extern RTI_BOOL
space_A_initialize(space_A* sample)
{
    CDR_Primitive_init_Int16(&sample->i1);


    CDR_Primitive_init_Int16(&sample->i2);


    CDR_Primitive_init_Int32(&sample->i3);


    CDR_Primitive_init_Int32(&sample->i4);


    CDR_Primitive_init_Int64(&sample->i5);


    CDR_Primitive_init_Int64(&sample->i6);


    CDR_Primitive_init_Uint16(&sample->i7);


    CDR_Primitive_init_Uint16(&sample->i8);


    CDR_Primitive_init_Uint32(&sample->i9);


    CDR_Primitive_init_Uint32(&sample->i10);


    CDR_Primitive_init_Uint64(&sample->i11);


    CDR_Primitive_init_Uint64(&sample->i12);


    CDR_Primitive_init_Char(&sample->c0);


    if (!CDR_String_initialize(&sample->c1, (255)))
    {
        return RTI_FALSE;
    }


    CDR_Primitive_init_Boolean(&sample->c2);


    CDR_Primitive_init_Float(&sample->c3);


    CDR_Primitive_init_Double(&sample->c4);


    CDR_Primitive_init_LongDouble(&sample->c5);


    CDR_Primitive_init_Int16(&sample->arr[10]);


    return RTI_TRUE;
}

NDDSUSERDllExport extern RTI_BOOL
space_A_finalize(space_A* sample)
{
    UNUSED_ARG(sample);
    CDR_String_finalize(&sample->c1);
    {
        RTI_UINT32 i;
            for (i = 0







    return RTI_TRUE;
}

#ifdef NDDS_USER_DLL_EXPORT
#if (defined(RTI_WIN32) || defined(RTI_WINCE))
/* If the code is building on Windows, stop exporting symbols. */
#undef NDDSUSERDllExport
#define NDDSUSERDllExport
#endif
#endif

#endif /* no_module */
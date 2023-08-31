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

};

extern const char *space_ATYPENAME;

REDA_DEFINE_SEQUENCE_STRUCT(space_ASeq, space_A);

REDA_DEFINE_SEQUENCE_IN_C(space_ASeq,space_A);

NDDSUSERDllExport extern RTI_BOOL
space_A_initialize(space_A* sample)
{
    CDR_Primitive_init_Int16(&sample->i1);


    return RTI_TRUE;
}

NDDSUSERDllExport extern RTI_BOOL
space_A_finalize(space_A* sample)
{
    UNUSED_ARG(sample);
    return RTI_TRUE;
}
struct space_BSeq;
class space_BTypeSupport;
class space_BDataWriter;
class space_BDataReader;
class space_B
{
  public:
    typedef struct space_BSeq Seq;
    typedef space_BTypeSupport TypeSupport;
    typedef space_BDataWriter DataWriter;
    typedef space_BDataReader DataReader;

    CDR_Int32 i2 = 100;


    CDR_space::A i3;

};

extern const char *space_BTYPENAME;

REDA_DEFINE_SEQUENCE_STRUCT(space_BSeq, space_B);

REDA_DEFINE_SEQUENCE_IN_C(space_BSeq,space_B);

NDDSUSERDllExport extern RTI_BOOL
space_B_initialize(space_B* sample)
{
    CDR_Primitive_init_Int32(&sample->i2);


    CDR_Primitive_init_space::A(&sample->i3);


    return RTI_TRUE;
}

NDDSUSERDllExport extern RTI_BOOL
space_B_finalize(space_B* sample)
{
    UNUSED_ARG(sample);
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